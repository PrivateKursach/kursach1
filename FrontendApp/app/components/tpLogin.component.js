var tpLoginComponent = {
    templateUrl : "./templates/tpLogin.template.html",
    controller : LoginController
};

function LoginController(sessionService, $rootScope, $cookies, $state) {
    var $ctrl = this;

    $ctrl.login = function () {
        sessionService.createSession($ctrl.loginForm).then(function (sessionData) {
            $cookies.put("sessionUserId", sessionData.id);
            $cookies.put("sessionUserRole", sessionData.role);
            $rootScope.sessionUserId = sessionData.id;
            $rootScope.sessionUserRole = sessionData.role;
            $state.go("welcome");
        });
    };
}