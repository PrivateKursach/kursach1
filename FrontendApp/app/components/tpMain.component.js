var tpMainComponent = {
    templateUrl : "./templates/tpMain.template.html",
    controller : MainController
};

function MainController($rootScope, $cookies, $state) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        $rootScope.sessionUserId = $cookies.get("sessionUserId");
        $rootScope.sessionUserRole = $cookies.get("sessionUserRole");
    };

    $ctrl.logout = function () {
        $rootScope.sessionUserId = undefined;
        $rootScope.sessionRole = undefined;
        $cookies.put("sessionUserId", undefined);
        $cookies.put("sessionRole", undefined);

        $state.go("welcome");
    };
    
    $ctrl.isLogged = function () {
        return $rootScope.sessionUserId;
    };

    $ctrl.isAdmin = function () {
        return $rootScope.sessionUserRole == 0;
    };
}