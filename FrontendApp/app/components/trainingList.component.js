var trainingListComponent = {
    templateUrl : "./templates/trainingList.template.html",
    controller : TrainingListController
};

function TrainingListController(trainingService, $state, $stateParams, $rootScope) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        var page = parseInt($stateParams.page, 10);
        var limit = 10;
        var offset = (page - 1) * limit;

        $ctrl.searchForm = {
            name: $stateParams.name,
            trainer: $stateParams.trainer,
            location: $stateParams.location,
            minStartDate: $stateParams.minDate,
            maxStartDate: $stateParams.maxDate,
            types: ($stateParams.types) ? $stateParams.types.toString().split(",") : []
        };
        console.log($ctrl.searchForm);
        trainingService.getTrainings().then(function (response) {
            $ctrl.allTrainings = response;
            console.log($ctrl.allTrainings);
            var filteredTrainings = [];
            $ctrl.allTrainings.forEach(function (training) {
                if (matchesSearchForm(training)) {
                    filteredTrainings.push(training);
                }
            });
            console.log(filteredTrainings);
            $ctrl.trainingList = filteredTrainings.slice(offset, offset + limit);
            console.log(offset);
            console.log(limit);
            console.log($ctrl.trainingList);
            $ctrl.totalItems = filteredTrainings.length;
            console.log($ctrl.totalItems);
            $ctrl.itemsPerPage = limit;
            $ctrl.currentPage = page;
        }, function (errResponse) {
            $ctrl.errorMessage = "Ошибка сервера";
        });
        trainingService.getAllTrainingTypes().then(function (response) {
            $ctrl.types = response;
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

    $ctrl.applySearch = function () {
        $state.go(
            '.',
            {
                page: 1,
                name: $ctrl.searchForm.name,
                trainer: $ctrl.searchForm.trainer,
                location: $ctrl.searchForm.location,
                minDate: $ctrl.searchForm.minStartDate,
                maxDate: $ctrl.searchForm.maxStartDate,
                types: ($ctrl.searchForm.types.length == 0) ? null : $ctrl.searchForm.types.toString()
            },
            { notify: false }
        );
    };
    
    function matchesSearchForm(training) {
        var matchesName = $ctrl.searchForm.name ? training.name.indexOf($ctrl.searchForm.name) !== -1 : true;
        var matchesTrainer = $ctrl.searchForm.trainer ? training.trainer.indexOf($ctrl.searchForm.trainer) !== -1 : true;
        var matchesLocation = $ctrl.searchForm.location ? training.location.indexOf($ctrl.searchForm.location) !== -1 : true;
        var matchesMinStartDate = $ctrl.searchForm.minStartDate ? training.startDate > $ctrl.searchForm.minStartDate !== -1 : true;
        var matchesMaxStartDate = $ctrl.searchForm.maxStartDate ? training.startDate < $ctrl.searchForm.maxStartDate !== -1 : true;
        var matchesTypes = true;
        return matchesName && matchesTrainer && matchesLocation && matchesMinStartDate && matchesMaxStartDate && matchesTypes;
    }

}