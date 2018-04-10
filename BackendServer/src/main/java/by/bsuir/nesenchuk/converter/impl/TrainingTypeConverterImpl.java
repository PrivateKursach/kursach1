package by.bsuir.nesenchuk.converter.impl;

import by.bsuir.nesenchuk.converter.TrainingTypeConverter;
import by.bsuir.nesenchuk.dto.TrainingTypeDTO;
import by.bsuir.nesenchuk.entity.TrainingType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainingTypeConverterImpl implements TrainingTypeConverter {

    @Override
    public TrainingTypeDTO convertToDTO(TrainingType trainingType) {
        TrainingTypeDTO trainingTypeDTO = new TrainingTypeDTO();
        trainingTypeDTO.setId(trainingType.getId());
        trainingTypeDTO.setName(trainingType.getName());
        return trainingTypeDTO;
    }

    @Override
    public TrainingType convertToEntity(TrainingTypeDTO trainingTypeDTO) {
        TrainingType trainingType = new TrainingType();
        trainingType.setId(trainingTypeDTO.getId());
        trainingType.setName(trainingTypeDTO.getName());
        return trainingType;
    }

    @Override
    public List<TrainingTypeDTO> convertToDTOList(List<TrainingType> trainingTypes) {
        List<TrainingTypeDTO> trainingTypeDTOList = new ArrayList<>(trainingTypes.size());
        trainingTypeDTOList.addAll(trainingTypes.stream().map(this::convertToDTO).collect(Collectors.toList()));
        return trainingTypeDTOList;
    }
}
