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
    public List<TrainingType> getTrainingTypes() {
        return trainingTypeDAO.getTrainingTypes();
    }
}
