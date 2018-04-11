var rateTrainingComponent = {
    templateUrl : "./templates/rateTraining.template.html",
    controller : RateTrainingController,
    bindings : {
        resolve: '<',
        close: '&',
        dismiss: '&'
    }
};

function RateTrainingController(requestService) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        $ctrl.request = $ctrl.resolve.request;
    };

    $ctrl.rateTraining = function () {
        var promise = requestService.updateRequest({
            id: $ctrl.request.id,
            training: {
                id: $ctrl.request.training.id
            },
            user: {
                id: $ctrl.request.user.id
            },
            status: $ctrl.request.status,
            rating: $ctrl.rating,
            dateCreated: $ctrl.request.dateCreated
        });
        promise.then(function () {
            $ctrl.close();
        });
    };
}