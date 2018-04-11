var trainingComponent = {
    templateUrl : "./templates/training.template.html",
    controller : TrainingController
};

function TrainingController(trainingService, requestService, $rootScope, $stateParams, $state, $uibModal) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        $ctrl.trainingId = $stateParams.trainingId;
        trainingService.getTrainingById($ctrl.trainingId).then(function (response) {
            $ctrl.training = response
        });
        if ($rootScope.sessionUserRole == 1) {
            requestService.getRequestsByUserId($rootScope.sessionUserId).then(function (response) {
                response.forEach(function (item, i, arr) {
                    if (item.training.id == $ctrl.trainingId) {
                        $ctrl.trainingRequest = item;
                    }
                });
            });
        }
    };

    $ctrl.isLogged = function () {
        return $rootScope.sessionUserId;
    };

    $ctrl.isAdmin = function () {
        return $rootScope.sessionUserRole == 0;
    };

    $ctrl.openDeleteTrainingModal = function (trainingId) {
        var modalInstance = $uibModal.open({
            component : "DeleteTraining",
            resolve : {
                trainingId : function () {
                    return trainingId;
                }
            }
        });
        modalInstance.result.then(function () {
            $state.go("trainingList");
        });
    };

    $ctrl.rateTraining = function () {
        var modalInstance = $uibModal.open({
            component : "rateTraining",
            resolve : {
                request : function () {
                    return $ctrl.trainingRequest;
                }
            }
        });
        modalInstance.result.then(function () {
            requestService.getRequestById($ctrl.trainingRequest.id).then(function (response) {
                $ctrl.trainingRequest = response;
            });
        });
    }
}