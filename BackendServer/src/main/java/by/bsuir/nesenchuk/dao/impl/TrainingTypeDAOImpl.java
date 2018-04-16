package by.bsuir.nesenchuk.dao.impl;

import by.bsuir.nesenchuk.dao.TrainingTypeDAO;
import by.bsuir.nesenchuk.entity.TrainingType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TrainingTypeDAOImpl implements TrainingTypeDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public TrainingType createTrainingType(TrainingType trainingType) {
        entityManager.persist(trainingType);
        return trainingType;
    }

    @Override
    public TrainingType updateTrainingType(TrainingType trainingType) {
        return entityManager.merge(trainingType);
    }

    @Override
    public TrainingType getTrainingTypeById(Long id) {
        return entityManager.find(TrainingType.class, id);
    }

    @Override
    public void deleteTrainingType(Long id) {
        TrainingType trainingType = entityManager.find(TrainingType.class, id);
        entityManager.remove(trainingType);
    }

    @Override
    public List<TrainingType> getTrainingTypes() {
        return entityManager.createQuery("select tt from TrainingType tt", TrainingType.class).getResultList();
    }
}
