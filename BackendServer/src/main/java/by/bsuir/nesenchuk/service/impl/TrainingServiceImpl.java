package by.bsuir.nesenchuk.service.impl;

import by.bsuir.nesenchuk.dao.TrainingDAO;
import by.bsuir.nesenchuk.dto.TrainingDTO;
import by.bsuir.nesenchuk.dto.converter.impl.TrainingDTOConverter;
import by.bsuir.nesenchuk.entity.Training;
import by.bsuir.nesenchuk.service.TrainingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrainingServiceImpl extends GenericServiceImpl<Training, TrainingDTO, Long> implements TrainingService {

    private TrainingDAO trainingDAO;
    private TrainingDTOConverter trainingDTOConverter;

    @Override
    public List<TrainingDTO> getTrainings() {
        List<Training> trainings = trainingDAO.getTrainings();
        return trainingDTOConverter.getDtoList(trainings);
    }

    public void setTrainingDAO(TrainingDAO trainingDAO) {
        setGenericDao(trainingDAO);
        this.trainingDAO = trainingDAO;
    }

    public void setTrainingDTOConverter(TrainingDTOConverter trainingDTOConverter) {
        setDtoConverter(trainingDTOConverter);
        this.trainingDTOConverter = trainingDTOConverter;
    }
}
