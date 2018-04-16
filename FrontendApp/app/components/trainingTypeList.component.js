var trainingTypeListComponent = {
    templateUrl : "./templates/trainingTypeList.template.html",
    controller : TrainingTypeListController
};

function TrainingTypeListController(trainingService, $state, $stateParams, $uibModal) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        var page = parseInt($stateParams.page, 10);
        var limit = 10;
        var offset = (page - 1) * limit;
        trainingService.getAllTrainingTypes().then(function (response) {
            $ctrl.allTypes = response;
            $ctrl.types = $ctrl.allTypes.slice(offset, offset + limit);
            $ctrl.totalItems = $ctrl.allTypes.length;
            $ctrl.itemsPerPage = limit;
            $ctrl.currentPage = page;
        });
    };

    $ctrl.pageChanged = function (currentPage) {
        $state.go('.', { page: currentPage }, { notify: false });
    };

}