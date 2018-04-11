package by.bsuir.nesenchuk.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrainingStatsDTO {

    private List<TrainingRequestsStats> requestsStats = new ArrayList<>();
    private List<TrainingRatesStats> ratesStats = new ArrayList<>();

    public List<TrainingRequestsStats> getRequestsStats() {
        return requestsStats;
    }

    public void setRequestsStats(List<TrainingRequestsStats> requestsStats) {
        this.requestsStats = requestsStats;
    }

    public void addRequestsStats(LocalDate dateFrom, LocalDate dateTo, Integer numberOfRequests) {
        TrainingRequestsStats requestsStats = new TrainingRequestsStats();
        requestsStats.setDateFrom(dateFrom);
        requestsStats.setDateTo(dateTo);
        requestsStats.setNumberOfRequests(numberOfRequests);
        this.requestsStats.add(requestsStats);
    }

    public List<TrainingRatesStats> getRatesStats() {
        return ratesStats;
    }

    public void setRatesStats(List<TrainingRatesStats> ratesStats) {
        this.ratesStats = ratesStats;
    }

    public void addRatesStats(LocalDate dateFrom, LocalDate dateTo, Double averageRating) {
        TrainingRatesStats trainingRatesStats = new TrainingRatesStats();
        trainingRatesStats.setDateFrom(dateFrom);
        trainingRatesStats.setDateTo(dateTo);
        trainingRatesStats.setAverageRate(averageRating);
        this.ratesStats.add(trainingRatesStats);
    }

    public class TrainingRequestsStats {
        private LocalDate dateFrom;
        private LocalDate dateTo;
        private Integer numberOfRequests;

        public LocalDate getDateFrom() {
            return dateFrom;
        }

        public void setDateFrom(LocalDate dateFrom) {
            this.dateFrom = dateFrom;
        }

        public LocalDate getDateTo() {
            return dateTo;
        }

        public void setDateTo(LocalDate dateTo) {
            this.dateTo = dateTo;
        }

        public Integer getNumberOfRequests() {
            return numberOfRequests;
        }

        public void setNumberOfRequests(Integer numberOfRequests) {
            this.numberOfRequests = numberOfRequests;
        }
    }

    public class TrainingRatesStats {
        private LocalDate dateFrom;
        private LocalDate dateTo;
        private Double averageRate;

        public LocalDate getDateFrom() {
            return dateFrom;
        }

        public void setDateFrom(LocalDate dateFrom) {
            this.dateFrom = dateFrom;
        }

        public LocalDate getDateTo() {
            return dateTo;
        }

        public void setDateTo(LocalDate dateTo) {
            this.dateTo = dateTo;
        }

        public Double getAverageRate() {
            return averageRate;
        }

        public void setAverageRate(Double averageRate) {
            this.averageRate = averageRate;
        }
    }
}
