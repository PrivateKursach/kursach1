package by.bsuir.nesenchuk.converter;

import by.bsuir.nesenchuk.dto.TrainingTypeDTO;
import by.bsuir.nesenchuk.entity.TrainingType;

import java.util.List;

public interface TrainingTypeConverter {
    TrainingTypeDTO convertToDTO(TrainingType trainingType);
    TrainingType convertToEntity(TrainingTypeDTO trainingTypeDTO);
    List<TrainingTypeDTO> convertToDTOList(List<TrainingType> trainingTypes);
}
