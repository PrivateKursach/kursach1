package by.bsuir.nesenchuk.service.impl;

import by.bsuir.nesenchuk.dao.TrainingTypeDAO;
import by.bsuir.nesenchuk.entity.TrainingType;
import by.bsuir.nesenchuk.service.TrainingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrainingTypeServiceImpl implements TrainingTypeService {

    @Autowired
    private TrainingTypeDAO trainingTypeDAO;

    @Override
    public TrainingType createTrainingType(TrainingType trainingType) {
        return trainingTypeDAO.createTrainingType(trainingType);
    }

    @Override
    public TrainingType updateTrainingType(TrainingType trainingType) {
        return trainingTypeDAO.updateTrainingType(trainingType);
    }

    @Override
    public void deleteTrainingType(Long id) {
        trainingTypeDAO.deleteTrainingType(id);
    }

    @Override
    public List<TrainingType> getTrainingTypes() {
        return trainingTypeDAO.getTrainingTypes();
    }
}
