package by.bsuir.nesenchuk.service.impl;

import by.bsuir.nesenchuk.dao.TrainingDAO;
import by.bsuir.nesenchuk.entity.Training;
import by.bsuir.nesenchuk.exception.EntityNotFoundException;
import by.bsuir.nesenchuk.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingDAO trainingDAO;

    @Override
    public Training createTraining(Training training) {
       return trainingDAO.createTraining(training);
    }

    @Override
    public Training getTrainingById(Long id) {
        Training training = trainingDAO.getTrainingById(id);
        if (training == null) {
            throw new EntityNotFoundException();
        }
        return training;
    }

    @Override
    public Training updateTraining(Training training) {
        if (trainingDAO.getTrainingById(training.getId()) == null) {
            throw new EntityNotFoundException();
        }
        return trainingDAO.updateTraining(training);
    }

    @Override
    public void deleteTraining(Long id) {
        if (trainingDAO.getTrainingById(id) == null) {
            throw new EntityNotFoundException();
        }
        trainingDAO.deleteTraining(id);
    }

    @Override
    public List<Training> getTrainings() {
        return trainingDAO.getTrainings();
    }

    @Override
    public List<String> getTrainers() {
        List<Training> trainings = getTrainings();
        Set<String> trainers = new HashSet<>(trainings.size());
        trainers.addAll(trainings.stream().map(Training::getTrainerName).collect(Collectors.toList()));
        return new ArrayList<>(trainers);
    }

    @Override
    public List<String> getLocations() {
        List<Training> trainings = getTrainings();
        Set<String> locations = new HashSet<>(trainings.size());
        locations.addAll(trainings.stream().map(Training::getLocation).collect(Collectors.toList()));
        return new ArrayList<>(locations);
    }

}
