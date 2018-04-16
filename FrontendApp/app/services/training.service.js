function trainingService($http) {
    var service = this;

    service.getTrainings = function () {
        return $http({
            method: "GET",
            url: "http://localhost:8081/rest/trainings"
        }).then(function (response) {
            return response.data;
        });
    };

    service.getTrainingById = function (trainingId) {
        return $http({
            method: "GET",
            url: "http://localhost:8081/rest/trainings/" + trainingId
        }).then(function (response) {
            return response.data;
        });
    };

    service.createTraining = function (training) {
        return $http({
            method : "POST",
            url : "http://localhost:8081/rest/trainings",
            data : training
        }).then(function (response) {
            return response.data;
        });
    };

    service.updateTraining = function (training) {
        return $http({
            method : "PUT",
            url : "http://localhost:8081/rest/trainings/" + training.id,
            data : training
        }).then(function (response) {
            return response.data;
        });
    };

    service.deleteTraining = function (trainingId) {
        return $http({
            method : "DELETE",
            url : "http://localhost:8081/rest/trainings/" + trainingId
        });
    };

    service.getAllTrainingTypes = function () {
        return $http({
            method: "GET",
            url: "http://localhost:8081/rest/trainings/types"
        }).then(function (response) {
            return response.data;
        });
    };

    service.getAllTrainingTrainers = function () {
        return $http({
            method: "GET",
            url: "http://localhost:8081/rest/trainings/trainers"
        }).then(function (response) {
            return response.data;
        });
    };

    service.getAllTrainingLocations = function () {
        return $http({
            method: "GET",
            url: "http://localhost:8081/rest/trainings/locations"
        }).then(function (response) {
            return response.data;
        });
    };
    
    service.getStatsByTrainingId = function (trainingId) {
        return $http({
            method: "GET",
            url: "http://localhost:8081/rest/trainings/" + trainingId + "/stats"
        }).then(function (response) {
            return response.data;
        });
    };
}