package by.bsuir.nesenchuk.dao.impl;

import by.bsuir.nesenchuk.dao.TrainingDAO;
import by.bsuir.nesenchuk.entity.Training;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TrainingDAOImpl implements TrainingDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Training createTraining(Training training) {
        entityManager.persist(training);
        return training;
    }

    @Override
    public Training getTrainingById(Long id) {
        return entityManager.find(Training.class, id);
    }

    @Override
    public Training updateTraining(Training training) {
        return entityManager.merge(training);
    }

    @Override
    public void deleteTraining(Long id) {
        Training training = entityManager.find(Training.class, id);
        entityManager.remove(training);
    }

    @Override
    public List<Training> getTrainings() {
        TypedQuery<Training> query = entityManager.createQuery("select t from Training t", Training.class);
        return query.getResultList();
    }

}
