var trainingComponent = {
    templateUrl : "./templates/training.template.html",
    controller : TrainingController
};

function TrainingController(trainingService, $rootScope, $stateParams) {
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
}