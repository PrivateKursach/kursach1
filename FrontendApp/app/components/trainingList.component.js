var trainingListComponent = {
    templateUrl : "./templates/trainingList.template.html",
    controller : TrainingListController
};

function TrainingListController(trainingService, $state, $stateParams, $rootScope, $uibModal) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        var page = parseInt($stateParams.page, 10);
        var limit = 10;
        var offset = (page - 1) * limit;

        $ctrl.searchForm = {
            name: $stateParams.name,
            trainer: $stateParams.trainer,
            location: $stateParams.location,
            minStartDate: $stateParams.minDate ? new Date($stateParams.minDate) : null,
            maxStartDate: $stateParams.maxDate ? new Date($stateParams.maxDate) : null,
            types: ($stateParams.types) ? $stateParams.types.toString().split(",") : []
        };
        $ctrl.searchForm.typesObj = [];
        trainingService.getTrainings().then(function (response) {
            $ctrl.allTrainings = response;
            var filteredTrainings = [];
            $ctrl.allTrainings.forEach(function (training) {
                if (matchesSearchForm(training)) {
                    filteredTrainings.push(training);
                }
            });
            $ctrl.trainingList = filteredTrainings.slice(offset, offset + limit);
            $ctrl.totalItems = filteredTrainings.length;
            $ctrl.itemsPerPage = limit;
            $ctrl.currentPage = page;
        }, function (errResponse) {
            $ctrl.errorMessage = "Ошибка сервера";
        });
        trainingService.getAllTrainingTypes().then(function (response) {
            $ctrl.types = response;
            if ($ctrl.searchForm.types) {
                $ctrl.types.forEach(function (item, index, arr) {
                    $ctrl.searchForm.types.forEach(function (searchFormItem, searchFormIndex, searchFormArr) {
                        if (item.id == searchFormItem) {
                            $ctrl.searchForm.typesObj.push(item);
                        }
                    });
                });
            }
        });
        trainingService.getAllTrainingTrainers().then(function (response) {
            $ctrl.trainers = response;
        });
        trainingService.getAllTrainingLocations().then(function (response) {
            $ctrl.locations = response;
        });
    };

    $ctrl.getStateInfo = function () {
        return {
            name: "welcome",
            params: $stateParams
        };
    };

    $ctrl.pageChanged = function (currentPage) {
        $state.go('.', { page: currentPage }, { notify: false });
    };

    $ctrl.isLogged = function () {
        return $rootScope.sessionUserId;
    };

    $ctrl.isAdmin = function () {
        return $rootScope.sessionUserRole == 0;
    };

    $ctrl.selectType = function ($item, $model, $label, $event) {
        $ctrl.typesInput = "";

        var typeIndex = $ctrl.searchForm.types.findIndex(function (type, index, types) {
            if (type == $item.id) {
                return true;
            }
        });

        if (typeIndex == -1) {
            $ctrl.searchForm.types.push($item.id);
            $ctrl.searchForm.typesObj.push($item);
        }
    };

    $ctrl.removeType = function (typeToRemove) {
        var typeIndex = $ctrl.searchForm.types.findIndex(function (type, index, types) {
            if (type == typeToRemove.id) {
                return true;
            }
        });

        $ctrl.searchForm.types.splice(typeIndex, 1);
        $ctrl.searchForm.typesObj.splice(typeIndex, 1);
    };

    $ctrl.applySearch = function () {
        $state.go(
            '.',
            {
                page: 1,
                name: $ctrl.searchForm.name,
                trainer: $ctrl.searchForm.trainer,
                location: $ctrl.searchForm.location,
                minDate: $ctrl.searchForm.minStartDate ? $ctrl.searchForm.minStartDate.toISOString().substring(0, 10) : null,
                maxDate: $ctrl.searchForm.maxStartDate ? $ctrl.searchForm.maxStartDate.toISOString().substring(0, 10) : null,
                types: ($ctrl.searchForm.types.length == 0) ? null : $ctrl.searchForm.types.toString()
            },
            { notify: false }
        );
    };

    $ctrl.showMinDatePicker = function () {
        $ctrl.isShowMinDatePicker = true;
    };

    $ctrl.showMaxDatePicker = function () {
        $ctrl.isShowMaxDatePicker = true;
    };
    
    $ctrl.createRequest = function (trainingId) {
        var modalInstance = $uibModal.open({
            component : "createRequest",
            resolve : {
                trainingId : function () {
                    return trainingId;
                },
                userId: function () {
                    return $rootScope.sessionUserId
                }
            }
        });
        modalInstance.result.then(function () {
            $state.go("requestList");
        });
    };
    
    function matchesSearchForm(training) {
        var matchesName = $ctrl.searchForm.name ? training.name.indexOf($ctrl.searchForm.name) !== -1 : true;
        var matchesTrainer = $ctrl.searchForm.trainer ? training.trainer.indexOf($ctrl.searchForm.trainer) !== -1 : true;
        var matchesLocation = $ctrl.searchForm.location ? training.location.indexOf($ctrl.searchForm.location) !== -1 : true;
        var matchesMinStartDate = $ctrl.searchForm.minStartDate ? new Date(training.startDate) >= $ctrl.searchForm.minStartDate : true;
        var matchesMaxStartDate = $ctrl.searchForm.maxStartDate ? new Date(training.startDate) <= $ctrl.searchForm.maxStartDate : true;
        var matchesTypes = true;
        if ($ctrl.searchForm.types && $ctrl.searchForm.types.length > 0) {
            matchesTypes = false;
            training.types.forEach(function (trainingType, i, trainingTypes) {
                $ctrl.searchForm.types.forEach(function (searchFormType, j, searchFormTypes) {
                    if (trainingType.id == searchFormType) {
                        matchesTypes = true;
                    }
                });
            });
        }
        return matchesName && matchesTrainer && matchesLocation && matchesMinStartDate && matchesMaxStartDate && matchesTypes;
    }

}