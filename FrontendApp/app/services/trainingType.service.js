function trainingTypeService($http) {
    var service = this;

    service.createTrainingType = function (trainingType) {
        return $http({
            method : "POST",
            url : "http://localhost:8081/rest/training-types",
            data : trainingType
        }).then(function (response) {
            return response.data;
        });
    };

    service.updateTrainingType = function (trainingType) {
        return $http({
            method : "PUT",
            url : "http://localhost:8081/rest/training-types/" + trainingType.id,
            data : trainingType
        }).then(function (response) {
            return response.data;
        });
    };

    service.deleteTrainingType = function (trainingTypeId) {
        return $http({
            method : "DELETE",
            url : "http://localhost:8081/rest/training-types/" + trainingTypeId
        });
    };
    
    service.getTrainingTypeById = function (trainingTypeId) {
        return $http({
            method : "GET",
            url : "http://localhost:8081/rest/training-types/" + trainingTypeId
        }).then(function (response) {
            return response.data;
        });
    };
}