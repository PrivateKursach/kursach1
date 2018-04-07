function routing($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/");

    var welcomeState = {
        name: "welcome",
        url: "/",
        component: "trainingList"
    };

    var trainingListState = {
        name: "trainingList",
        url: "/trainings",
        component: "trainingList"
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