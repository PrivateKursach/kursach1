package by.bsuir.nesenchuk.service.impl;

import by.bsuir.nesenchuk.dao.RequestDAO;
import by.bsuir.nesenchuk.dto.TrainingStatsDTO;
import by.bsuir.nesenchuk.entity.Request;
import by.bsuir.nesenchuk.service.TrainingStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TrainingStatsServiceImpl implements TrainingStatsService {

    @Autowired
    private RequestDAO requestDAO;

    @Override
    public TrainingStatsDTO getStats(Long trainingId) {
        LocalDate today = LocalDate.now();
        TrainingStatsDTO trainingStatsDTO = new TrainingStatsDTO();
        List<Request> requests = requestDAO.getRequestsByTrainingId(trainingId);
        for (int i = 10; i > 0; i--) {
            LocalDate dateFrom = today.minusDays((3 * i) - 1);
            LocalDate dateTo = dateFrom.plusDays(2);
            int numberOfRequests = 0;
            int summaryRating = 0;
            for (Request request : requests) {
                LocalDate dateCreated = request.getDateCreated();
                if ((dateCreated.isAfter(dateFrom) || dateCreated.isEqual(dateFrom)) &&
                        (dateCreated.isBefore(dateTo) || dateCreated.isEqual(dateTo))) {
                    numberOfRequests++;
                    summaryRating += request.getRating() == null ? 0 : request.getRating();
                }
            }
            trainingStatsDTO.addRequestsStats(dateFrom, dateTo, numberOfRequests);
            if (numberOfRequests > 0) {
                trainingStatsDTO.addRatesStats(dateFrom, dateTo, (double) summaryRating / (double) numberOfRequests);
            } else {
                trainingStatsDTO.addRatesStats(dateFrom, dateTo, 0.0);
            }
        }
        return trainingStatsDTO;
    }
}
