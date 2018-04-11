var createRequestComponent = {
    templateUrl : "./templates/createRequest.template.html",
    controller : CreateRequestController,
    bindings : {
        resolve: '<',
        close: '&',
        dismiss: '&'
    }
};

function CreateRequestController(requestService) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        $ctrl.trainingId = $ctrl.resolve.trainingId;
        $ctrl.userId = $ctrl.resolve.userId;
    };

    $ctrl.createRequest = function () {
        var promise = requestService.createRequest({
            training: {
                id: $ctrl.trainingId
            },
            user: {
                id: $ctrl.userId
            },
            status: 0,
            dateCreated: new Date().toISOString().substring(0, 10)
        });
        promise.then(function () {
            $ctrl.close();
        });
    };
}