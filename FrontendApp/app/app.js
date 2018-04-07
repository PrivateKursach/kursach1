angular.module("app", ["ngCookies", "ui.router", "ui.bootstrap"])
    .config(routing)
    .service("trainingService", trainingService)
    .component("tpMain", tpMainComponent)
    .component("trainingList", trainingListComponent)
    .component("tpPagination", tpPaginationComponent);