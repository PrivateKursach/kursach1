var deleteTrainingTypeComponent = {
    templateUrl : "./templates/deleteTrainingType.template.html",
    controller : DeleteTrainingTypeController,
    bindings : {
        resolve: '<',
        close: '&',
        dismiss: '&'
    }
};

function DeleteTrainingTypeController(trainingTypeService) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        $ctrl.trainingTypeId = $ctrl.resolve.trainingTypeId;
    };

    $ctrl.deleteTrainingType = function () {
        var promise = trainingTypeService.deleteTrainingType($ctrl.trainingTypeId);
        promise.then(function () {
            $ctrl.close();
        });
    };
}