var approveRequestComponent = {
    templateUrl : "./templates/approveRequest.template.html",
    controller : ApproveRequestController,
    bindings : {
        resolve: '<',
        close: '&',
        dismiss: '&'
    }
};

function ApproveRequestController(requestService) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        $ctrl.request = $ctrl.resolve.request;
    };

    $ctrl.approveRequest = function () {
        var promise = requestService.updateRequest({
            id: $ctrl.request.id,
            user: {
                id: $ctrl.request.user.id
            },
            training: {
                id: $ctrl.request.training.id
            },
            status: 1,
            rating: $ctrl.request.rating,
            dateCreated: $ctrl.request.dateCreated
        });
        promise.then(function () {
            $ctrl.close();
        });
    };
}