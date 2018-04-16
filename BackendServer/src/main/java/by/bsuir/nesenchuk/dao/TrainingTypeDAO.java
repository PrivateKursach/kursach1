package by.bsuir.nesenchuk.dao;

import by.bsuir.nesenchuk.entity.TrainingType;

import java.util.List;

public interface TrainingTypeDAO {
    TrainingType createTrainingType(TrainingType trainingType);
    TrainingType updateTrainingType(TrainingType trainingType);
    TrainingType getTrainingTypeById(Long id);
    void deleteTrainingType(Long id);
    List<TrainingType> getTrainingTypes();
}
