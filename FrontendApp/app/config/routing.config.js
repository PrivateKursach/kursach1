function routing($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/");

    var welcomeState = {
        name: "welcome",
        url: "/?page",
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
        url: "/trainings?page",
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

    $stateProvider.state(welcomeState);
    $stateProvider.state(trainingListState);
    $stateProvider.state(registrationState);
    $stateProvider.state(loginState);
}