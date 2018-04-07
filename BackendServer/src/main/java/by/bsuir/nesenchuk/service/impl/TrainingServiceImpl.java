package by.bsuir.nesenchuk.service.impl;

import by.bsuir.nesenchuk.dao.TrainingDAO;
import by.bsuir.nesenchuk.entity.Training;
import by.bsuir.nesenchuk.exception.EntityNotFoundException;
import by.bsuir.nesenchuk.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<Training> getTrainings(int offset, int limit) {
        return trainingDAO.getTrainings(offset, limit);
    }

}
