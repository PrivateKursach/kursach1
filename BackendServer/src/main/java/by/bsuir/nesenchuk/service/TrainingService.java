package by.bsuir.nesenchuk.service;

import by.bsuir.nesenchuk.dto.TrainingDTO;

import java.util.List;

public interface TrainingService extends GenericService<TrainingDTO, Long> {
    List<TrainingDTO> getTrainings();
}
