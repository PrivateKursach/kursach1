var trainingListComponent = {
    templateUrl : "./templates/trainingList.template.html",
    controller : TrainingListController
};

function TrainingListController(trainingService, $state, $stateParams, $rootScope) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        var page = parseInt($stateParams.page, 10);
        var limit = 20;
        var offset = (page - 1) * limit;
        trainingService.getTrainings().then(function (response) {
            $ctrl.trainingList = response.slice(offset, offset + limit);
            $ctrl.totalItems = response.length;
            $ctrl.itemsPerPage = limit;
            $ctrl.currentPage = page;
        }, function (errResponse) {
            $ctrl.errorMessage = "Ошибка сервера";
        });
    };

    $ctrl.getStateInfo = function () {
        return {
            name: "welcome",
            params: $stateParams
        };
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

}