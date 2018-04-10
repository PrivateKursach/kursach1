package by.bsuir.nesenchuk.converter.impl;

import by.bsuir.nesenchuk.converter.TrainingConverter;
import by.bsuir.nesenchuk.converter.TrainingTypeConverter;
import by.bsuir.nesenchuk.dto.TrainingDTO;
import by.bsuir.nesenchuk.dto.TrainingTypeDTO;
import by.bsuir.nesenchuk.entity.Training;
import by.bsuir.nesenchuk.entity.TrainingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TrainingConverterImpl implements TrainingConverter {

    @Autowired
    private TrainingTypeConverter trainingTypeConverter;

    @Override
    public TrainingDTO convertToDTO(Training training) {
        TrainingDTO trainingDTO = new TrainingDTO();
        trainingDTO.setId(training.getId());
        trainingDTO.setName(training.getName());
        trainingDTO.setDescription(training.getDescription());
        trainingDTO.setStartDate(training.getStartDate());
        trainingDTO.setEndDate(training.getEndDate());
        trainingDTO.setTrainer(training.getTrainerName());
        trainingDTO.setLocation(training.getLocation());
        trainingDTO.setTypes(trainingTypeConverter.convertToDTOList(new ArrayList<>(training.getTypes())));
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
        training.setTrainerName(trainingDTO.getTrainer());
        training.setLocation(trainingDTO.getLocation());
        if (!trainingDTO.getTypes().isEmpty()) {
            Set<TrainingType> trainingTypes = new HashSet<>(trainingDTO.getTypes().size());
            trainingTypes.addAll(trainingDTO.getTypes().stream().map(trainingTypeDTO -> trainingTypeConverter.convertToEntity(trainingTypeDTO)).collect(Collectors.toList()));
            training.setTypes(trainingTypes);
        }
        return training;
    }

    @Override
    public List<TrainingDTO> convertToDTOList(List<Training> trainings) {
        List<TrainingDTO> trainingDTOList = new ArrayList<>(trainings.size());
        trainingDTOList.addAll(trainings.stream().map(this::convertToDTO).collect(Collectors.toList()));
        return trainingDTOList;
    }
}
