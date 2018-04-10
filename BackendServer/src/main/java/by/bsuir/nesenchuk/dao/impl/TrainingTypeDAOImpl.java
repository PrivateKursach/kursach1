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
    public List<TrainingType> getTrainingTypes() {
        return entityManager.createQuery("select tt from TrainingType tt", TrainingType.class).getResultList();
    }
}
