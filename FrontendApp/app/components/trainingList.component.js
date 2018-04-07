var trainingListComponent = {
    templateUrl : "./templates/trainingList.template.html",
    controller : TrainingListController
};

function TrainingListController(trainingService, $state, $stateParams) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        var page = parseInt($stateParams.page, 10);
        trainingService.getTrainings().then(function (response) {
            $ctrl.trainingList = response;
            $ctrl.totalItems = $ctrl.trainingList.length;
            $ctrl.itemsPerPage = 20;
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

}