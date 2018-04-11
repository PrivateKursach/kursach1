function requestService($http) {
    var service = this;

    service.getAllRequests = function () {
        return $http({
            method: "GET",
            url: "http://localhost:8081/rest/requests"
        }).then(function (response) {
            return response.data;
        });
    };

    service.getRequestsByUserId = function (userId) {
        return $http({
            method: "GET",
            url: "http://localhost:8081/rest/users/" + userId + "/requests" 
        }).then(function (response) {
            return response.data;
        });
    };

    service.getRequestById = function (requestId) {
        return $http({
            method: "GET",
            url: "http://localhost:8081/rest/requests/" + requestId
        }).then(function (response) {
            return response.data;
        });
    };

    service.createTraining = function (request) {
        return $http({
            method : "POST",
            url : "http://localhost:8081/rest/users/" + request.user.id + "/requests",
            data : request
        }).then(function (response) {
            return response.data;
        });
    };

    service.updateRequest = function (request) {
        return $http({
            method : "PUT",
            url : "http://localhost:8081/rest/requests/" + request.id,
            data : request
        }).then(function (response) {
            return response.data;
        });
    };
}