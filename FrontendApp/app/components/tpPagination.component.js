var tpPaginationComponent = {
    templateUrl : "./templates/tpPagination.template.html",
    controller : tpPaginationController,
    bindings: {
    currentPage: '<',
        itemsPerPage: '<',
        totalItems: '<',
        onPageChanged: '&'
    }
};

function tpPaginationController() {
    var $ctrl = this;

    $ctrl.pageChanged = function () {
        $ctrl.onPageChanged({ currentPage: $ctrl.currentPage });
    };
}