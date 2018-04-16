var updateTrainingTypeComponent = {
    templateUrl : "./templates/updateTrainingType.template.html",
    controller : UpdateTrainingTypeController
};

function UpdateTrainingTypeController(trainingTypeService, $state, $stateParams) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        trainingTypeService.getTrainingTypeById($stateParams.trainingTypeId).then(function (response) {
            $ctrl.trainingType = response;
        });
    };

    $ctrl.updateTrainingType = function () {
        trainingTypeService.updateTrainingType($ctrl.trainingType).then(function (response) {
            $state.go("trainingTypeList");
        });
    };
}