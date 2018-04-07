var tpMainComponent = {
    templateUrl : "./templates/tpMain.template.html",
    controller : MainController
};

function MainController($rootScope, $cookies, $state) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        $rootScope.sessionUserId = $cookies.get("sessionUserId");
        $rootScope.sessionUserRole = $cookies.get("sessionUserRole");
        $rootScope.isLogged = function () {
            return this.sessionUserId;
        };
        $rootScope.isAdmin = function () {
            return this.sessionUserRole == 0;
        };
    };

    $ctrl.logout = function () {
        $rootScope.sessionUserId = undefined;
        $rootScope.sessionRole = undefined;
        $cookies.put("sessionUserId", undefined);
        $cookies.put("sessionRole", undefined);

        $state.go("welcome");
    };
}