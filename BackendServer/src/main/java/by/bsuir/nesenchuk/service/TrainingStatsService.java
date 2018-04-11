package by.bsuir.nesenchuk.service;

import by.bsuir.nesenchuk.dto.TrainingStatsDTO;

public interface TrainingStatsService {
    TrainingStatsDTO getStats(Long trainingId);
}
