package by.bsuir.nesenchuk.dao;

import by.bsuir.nesenchuk.entity.Training;

import java.util.List;

public interface TrainingDAO extends GenericDAO<Training, Long> {
    List<Training> getTrainings();
}
