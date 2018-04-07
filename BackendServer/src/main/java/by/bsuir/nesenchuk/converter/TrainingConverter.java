package by.bsuir.nesenchuk.converter;

import by.bsuir.nesenchuk.dto.TrainingDTO;
import by.bsuir.nesenchuk.entity.Training;

import java.util.List;

public interface TrainingConverter {
    TrainingDTO convertToDTO(Training training);
    Training convertToEntity(TrainingDTO trainingDTO);
    List<TrainingDTO> convertToDTOList(List<Training> trainings);
}
