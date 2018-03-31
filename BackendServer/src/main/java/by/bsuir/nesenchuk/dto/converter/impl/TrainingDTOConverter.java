package by.bsuir.nesenchuk.dto.converter.impl;

import by.bsuir.nesenchuk.dto.TrainingDTO;
import by.bsuir.nesenchuk.dto.converter.DTOConverter;
import by.bsuir.nesenchuk.entity.Training;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainingDTOConverter implements DTOConverter<Training, TrainingDTO> {

    @Override
    public TrainingDTO getDto(Training entity) {
        TrainingDTO trainingDTO = new TrainingDTO();
        trainingDTO.setId(entity.getId());
        trainingDTO.setName(entity.getName());
        trainingDTO.setDescription(entity.getDescription());
        trainingDTO.setStartDate(entity.getStartDate());
        trainingDTO.setEndDate(entity.getEndDate());
        return trainingDTO;
    }

    @Override
    public Training getEntity(TrainingDTO dto) {
        Training training = new Training();
        training.setId(dto.getId());
        training.setName(dto.getName());
        training.setDescription(dto.getDescription());
        training.setStartDate(dto.getStartDate());
        training.setEndDate(dto.getEndDate());
        return training;
    }

    @Override
    public List<TrainingDTO> getDtoList(List<Training> entityList) {
        List<TrainingDTO> trainingDTOList = new ArrayList<>(entityList.size());
        trainingDTOList.addAll(entityList.stream().map(this::getDto).collect(Collectors.toList()));
        return trainingDTOList;
    }
}
