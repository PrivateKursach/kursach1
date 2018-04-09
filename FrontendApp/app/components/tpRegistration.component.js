var tpRegistrationComponent = {
    templateUrl : "./templates/tpRegistration.template.html",
    controller : RegistrationController
};

function RegistrationController(userService, $rootScope, $cookies, $state) {
    var $ctrl = this;

    $ctrl.register = function () {
        userService.createUser($ctrl.registrationForm).then(function (createdUser) {
            $cookies.put("sessionUserId", createdUser.id);
            $cookies.put("sessionUserRole", createdUser.role);
            $rootScope.sessionUserId = createdUser.id;
            $rootScope.sessionUserRole = createdUser.role;
            $state.go("welcome");
        })
    };
}