package by.bsuir.nesenchuk.dao;

import by.bsuir.nesenchuk.entity.Training;

import java.util.List;

public interface TrainingDAO {
    Training createTraining(Training training);
    Training getTrainingById(Long id);
    Training updateTraining(Training training);
    void deleteTraining(Long id);
    List<Training> getTrainings(int offset, int limit);
}
