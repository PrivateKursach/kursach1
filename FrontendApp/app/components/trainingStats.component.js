var trainingStatsComponent = {
    templateUrl : "./templates/trainingStats.template.html",
    controller : TrainingStatsController
};

function TrainingStatsController(trainingService, $stateParams) {
    var $ctrl = this;

    $ctrl.trainingRequestsChartData = {
        chart: {
            caption: "Динаминка регистарции на тренинг",
            subCaption: "За последние 30 дней",
            numberPrefix: "",
            theme: "ocean"
        },
        data: []
    };
    $ctrl.trainingRatesChartData = {
        chart: {
            caption: "Динамика оценок тренинга",
            subCaption: "За последние 30 дней",
            numberPrefix: "",
            theme: "ocean"
        },
        data: []
    };

    $ctrl.$onInit = function () {
        $ctrl.trainingId = $stateParams.trainingId;
        trainingService.getStatsByTrainingId($ctrl.trainingId).then(function (response) {
            var trainingRequestsChartData = [];
            var trainingRatesChartData = [];
            response.requestsStats.forEach(function (item, i, array) {
                trainingRequestsChartData.push({
                    label: "C " + item.dateFrom + " по " + item.dateTo,
                    value: item.numberOfRequests
                });
            });
            response.ratesStats.forEach(function (item, i, array) {
                trainingRatesChartData.push({
                    label: "C " + item.dateFrom + " по " + item.dateTo,
                    value: item.averageRate
                });
            });
            $ctrl.trainingRequestsChartData.data = trainingRequestsChartData;
            $ctrl.trainingRatesChartData.data = trainingRatesChartData;
        });
    };
}