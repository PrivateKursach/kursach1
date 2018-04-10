var updateTrainingComponent = {
    templateUrl : "./templates/updateTraining.template.html",
    controller : UpdateTrainingController
};

function UpdateTrainingController(trainingService, $state, $stateParams) {
    var $ctrl = this;

    $ctrl.$onInit = function () {
        trainingService.getTrainingById($stateParams.trainingId).then(function (response) {
            $ctrl.training = {
                id: response.id,
                name: response.name,
                trainer: response.trainer,
                location: response.location,
                description: response.description,
                startDate: new Date(response.startDate),
                endDate: new Date(response.endDate),
                types: response.types
            };
        });
        trainingService.getAllTrainingTypes().then(function (response) {
            $ctrl.types = response;
        });
        trainingService.getAllTrainingTrainers().then(function (response) {
            $ctrl.trainers = response;
        });
        trainingService.getAllTrainingLocations().then(function (response) {
            $ctrl.locations = response;
        });
    };

    $ctrl.selectType = function ($item, $model, $label, $event) {
        $ctrl.typesInput = "";

        var typeIndex = $ctrl.training.types.findIndex(function (type, index, types) {
            if (type.id == $item.id) {
                return true;
            }
        });

        if (typeIndex == -1) {
            $ctrl.training.types.push($item);
        }
    };

    $ctrl.removeType = function (typeToRemove) {
        var typeIndex = $ctrl.training.types.findIndex(function (type, index, types) {
            if (type.id == typeToRemove.id) {
                return true;
            }
        });

        $ctrl.training.types.splice(typeIndex, 1);
    };

    $ctrl.showStartDatePicker = function () {
        $ctrl.isShowStartDatePicker = true;
    };

    $ctrl.showEndDatePicker = function () {
        $ctrl.isShowEndDatePicker = true;
    };

    $ctrl.updateTraining = function () {
        trainingService.updateTraining({
            id: $ctrl.training.id,
            name: $ctrl.training.name,
            trainer: $ctrl.training.trainer,
            location: $ctrl.training.location,
            description: $ctrl.training.description,
            startDate: $ctrl.training.startDate.toISOString().substring(0, 10),
            endDate: $ctrl.training.endDate.toISOString().substring(0, 10),
            types: $ctrl.training.types
        }).then(function (response) {
            $state.go("training", { trainingId: $ctrl.training.id });
        });
    };
}