package by.bsuir.nesenchuk.converter.impl;

import by.bsuir.nesenchuk.converter.TrainingConverter;
import by.bsuir.nesenchuk.dto.TrainingDTO;
import by.bsuir.nesenchuk.entity.Training;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainingConverterImpl implements TrainingConverter {

    @Override
    public TrainingDTO convertToDTO(Training training) {
        TrainingDTO trainingDTO = new TrainingDTO();
        trainingDTO.setId(training.getId());
        trainingDTO.setName(training.getName());
        trainingDTO.setDescription(training.getDescription());
        trainingDTO.setStartDate(training.getStartDate());
        trainingDTO.setEndDate(training.getEndDate());
        return trainingDTO;
    }

    @Override
    public Training convertToEntity(TrainingDTO trainingDTO) {
        Training training = new Training();
        training.setId(trainingDTO.getId());
        training.setName(trainingDTO.getName());
        training.setDescription(trainingDTO.getDescription());
        training.setStartDate(trainingDTO.getStartDate());
        training.setEndDate(trainingDTO.getEndDate());
        return training;
    }

    @Override
    public List<TrainingDTO> convertToDTOList(List<Training> trainings) {
        List<TrainingDTO> trainingDTOList = new ArrayList<>(trainings.size());
        trainingDTOList.addAll(trainings.stream().map(this::convertToDTO).collect(Collectors.toList()));
        return trainingDTOList;
    }
}
