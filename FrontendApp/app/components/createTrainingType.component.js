var createTrainingTypeComponent = {
    templateUrl : "./templates/createTrainingType.template.html",
    controller : CreateTrainingTypeController
};

function CreateTrainingTypeController(trainingTypeService, $state) {
    var $ctrl = this;

    $ctrl.createTrainingType = function () {
        trainingTypeService.createTrainingType($ctrl.trainingType).then(function (response) {
            $state.go("trainingTypeList");
        });
    };
}