var requestListComponent = {
    templateUrl : "./templates/requestList.template.html",
    controller : RequestListController
};

function RequestListController(requestService, $state, $stateParams, $rootScope, $uibModal) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
       setRequestList();
    };

    $ctrl.pageChanged = function (currentPage) {
        $state.go('.', { page: currentPage }, { notify: false });
    };

    $ctrl.isLogged = function () {
        return $rootScope.sessionUserId;
    };

    $ctrl.isAdmin = function () {
        return $rootScope.sessionUserRole == 0;
    };
    
    $ctrl.approveRequest = function (request) {
        var modalInstance = $uibModal.open({
            component : "approveRequest",
            resolve : {
                request : function () {
                    return request;
                }
            }
        });
        modalInstance.result.then(function () {
            setRequestList();
        });
    };
    
    function setRequestList() {
        var page = parseInt($stateParams.page, 10);
        var limit = 10;
        var offset = (page - 1) * limit;
        if ($rootScope.sessionUserRole == 0) {
            requestService.getAllRequests().then(function (response) {
                $ctrl.allRequests = response;
                $ctrl.requestList = $ctrl.allRequests.slice(offset, offset + limit);
                $ctrl.totalItems = $ctrl.allRequests.length;
                $ctrl.itemsPerPage = limit;
                $ctrl.currentPage = page;
            });
        } else {
            requestService.getRequestsByUserId($rootScope.sessionUserId).then(function (response) {
                $ctrl.allRequests = response;
                $ctrl.requestList = $ctrl.allRequests.slice(offset, offset + limit);
                $ctrl.totalItems = $ctrl.allRequests.length;
                $ctrl.itemsPerPage = limit;
                $ctrl.currentPage = page;
            });
        }
    }

}