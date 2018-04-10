var createTrainingComponent = {
    templateUrl : "./templates/createTraining.template.html",
    controller : CreateTrainingController
};

function CreateTrainingController(trainingService, $state) {
    var $ctrl = this;
    
    $ctrl.$onInit = function () {
        $ctrl.training = {
            startDate: new Date(),
            endDate: new Date(),
            types: []
        };
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

        $ctrl.training.type.splice(typeIndex, 1);
    };

    $ctrl.showStartDatePicker = function () {
        $ctrl.isShowStartDatePicker = true;
    };

    $ctrl.showEndDatePicker = function () {
        $ctrl.isShowEndDatePicker = true;
    };

    $ctrl.createTraining = function () {
        trainingService.createTraining({
            name: $ctrl.training.name,
            trainer: $ctrl.training.trainer,
            location: $ctrl.training.location,
            description: $ctrl.training.description,
            startDate: $ctrl.training.startDate.toISOString().substring(0, 10),
            endDate: $ctrl.training.endDate.toISOString().substring(0, 10),
            types: $ctrl.training.types
        }).then(function (response) {
            $state.go("trainingList");
        });
    };
}