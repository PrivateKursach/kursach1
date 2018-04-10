var deleteTrainingComponent = {
    templateUrl : "./templates/deleteTraining.template.html",
    controller : DeleteTrainingController,
    bindings : {
        resolve: '<',
        close: '&',
        dismiss: '&'
    }
};

function DeleteTrainingController(trainingService) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        $ctrl.trainingId = $ctrl.resolve.trainingId;
    };

    $ctrl.deleteTraining = function () {
        var promise = trainingService.deleteTraining($ctrl.trainingId);
        promise.then(function () {
            $ctrl.close();
        });
    };
}