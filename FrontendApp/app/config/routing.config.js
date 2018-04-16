function routing($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/");

    var welcomeState = {
        name: "welcome",
        url: "/?page&name&trainer&location&minDate&maxDate&types",
        component: "trainingList",
        params: {
            page: {
                value: '1',
                squash: true
            }
        }
    };

    var trainingListState = {
        name: "trainingList",
        url: "/trainings?page&name&trainer&location&minDate&maxDate&types",
        component: "trainingList",
        params: {
            page: {
                value: '1',
                squash: true
            }
        }
    };

    var loginState = {
        name: "login",
        url: "/login",
        component: "tpLogin"
    };

    var registrationState = {
        name: "registration",
        url: "/registration",
        component: "tpRegistration"
    };
    
    var createTrainingState = {
        name: "createTraining",
        url: "/trainings/create",
        component: "createTraining"
    };
    
    var trainingState = {
        name: "training",
        url: "/trainings/{trainingId}",
        component: "training"
    };
    
    var updateTrainingState = {
        name: "updateTraining",
        url: "/trainings/{trainingId}/update",
        component: "updateTraining"
    };

    var requestListState = {
        name: "requestList",
        url: "/requests?page",
        component: "requestList",
        params: {
            page: {
                value: '1',
                squash: true
            }
        }
    };
    
    var trainingStatsState = {
        name: "trainingStats",
        url: "/trainings/{trainingId}/stats",
        component: "trainingStats"
    };
    
    var trainingTypeListState = {
        name: "trainingTypeList",
        url: "/training-types?page",
        component: "trainingTypeList",
        params: {
            page: {
                value: '1',
                squash: true
            }
        } 
    };
    
    var createTrainingTypeState = {
        name: "createTrainingType",
        url: "/training-types/create",
        component: "createTrainingType"
    };

    var updateTrainingTypeState = {
        name: "updateTrainingType",
        url: "/training-types/{trainingTypeId}/update",
        component: "updateTrainingType"
    };

    $stateProvider.state(welcomeState);
    $stateProvider.state(trainingListState);
    $stateProvider.state(registrationState);
    $stateProvider.state(loginState);
    $stateProvider.state(createTrainingState);
    $stateProvider.state(trainingState);
    $stateProvider.state(updateTrainingState);
    $stateProvider.state(requestListState);
    $stateProvider.state(trainingStatsState);
    $stateProvider.state(trainingTypeListState);
    $stateProvider.state(createTrainingTypeState);
    $stateProvider.state(updateTrainingTypeState);
}