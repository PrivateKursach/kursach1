package by.bsuir.nesenchuk.service;

import by.bsuir.nesenchuk.entity.TrainingType;

import java.util.List;

public interface TrainingTypeService {
    TrainingType createTrainingType(TrainingType trainingType);
    TrainingType updateTrainingType(TrainingType trainingType);
    TrainingType getTrainingTypeById(Long id);
    void deleteTrainingType(Long id);
    List<TrainingType> getTrainingTypes();
}
