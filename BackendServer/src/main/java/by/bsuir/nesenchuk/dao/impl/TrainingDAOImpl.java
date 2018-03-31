package by.bsuir.nesenchuk.dao.impl;

import by.bsuir.nesenchuk.dao.TrainingDAO;
import by.bsuir.nesenchuk.entity.Training;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TrainingDAOImpl extends GenericDAOImpl<Training, Long> implements TrainingDAO {

    public TrainingDAOImpl() {
        super(Training.class);
    }

    @Override
    public List<Training> getTrainings() {
        TypedQuery<Training> query = entityManager.createQuery("select t from Training t", Training.class);
        return query.getResultList();
    }

}
