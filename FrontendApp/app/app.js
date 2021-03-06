angular.module("app", ["ngCookies", "ui.router", "ui.bootstrap", "ng-fusioncharts"])
    .config(routing)
    .service("trainingService", trainingService)
    .service("sessionService", sessionService)
    .service("userService", userService)
    .service("requestService", requestService)
    .service("trainingTypeService", trainingTypeService)
    .filter("requestStatusFilter", requestStatusFilter)
    .component("tpMain", tpMainComponent)
    .component("trainingList", trainingListComponent)
    .component("tpPagination", tpPaginationComponent)
    .component("tpLogin", tpLoginComponent)
    .component("tpRegistration", tpRegistrationComponent)
    .component("createTraining", createTrainingComponent)
    .component("training", trainingComponent)
    .component("updateTraining", updateTrainingComponent)
    .component("deleteTraining", deleteTrainingComponent)
    .component("requestList", requestListComponent)
    .component("createRequest", createRequestComponent)
    .component("approveRequest", approveRequestComponent)
    .component("rateTraining", rateTrainingComponent)
    .component("trainingStats", trainingStatsComponent)
    .component("trainingTypeList", trainingTypeListComponent)
    .component("createTrainingType", createTrainingTypeComponent)
    .component("updateTrainingType", updateTrainingTypeComponent)
    .component("deleteTrainingType", deleteTrainingTypeComponent);