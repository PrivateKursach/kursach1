var trainingComponent = {
    templateUrl : "./templates/training.template.html",
    controller : TrainingController
};

function TrainingController(trainingService, $rootScope, $stateParams, $state, $uibModal) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        $ctrl.trainingId = $stateParams.trainingId;
        trainingService.getTrainingById($ctrl.trainingId).then(function (response) {
            $ctrl.training = response
        });
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
    }
}