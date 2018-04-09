function sessionService($http) {
    var service = this;

    service.createSession = function (loginData) {
        return $http({
            method: "POST",
            url: "http://localhost:8081/rest/sessions",
            data: loginData
        }).then(function (response) {
            return response.data;
        });
    };
}