package by.bsuir.nesenchuk.service.impl;

import by.bsuir.nesenchuk.dao.RequestDAO;
import by.bsuir.nesenchuk.dto.TrainingStatsDTO;
import by.bsuir.nesenchuk.service.TrainingStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TrainingStatsServiceImpl implements TrainingStatsService {

    @Autowired
    private RequestDAO requestDAO;

    @Override
    public TrainingStatsDTO getStats(Long trainingId) {
        return null;
    }
}
