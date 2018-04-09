function userService($http) {
    var service = this;

    service.createUser = function (user) {
        return $http({
            method: "POST",
            url: "http://localhost:8081/rest/users",
            data: user
        }).then(function (response) {
            return response.data;
        });
    };
}