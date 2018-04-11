package by.bsuir.nesenchuk.dao.impl;

import by.bsuir.nesenchuk.dao.RequestDAO;
import by.bsuir.nesenchuk.entity.Request;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RequestDAOImpl implements RequestDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Request createRequest(Request request) {
        entityManager.persist(request);
        return request;
    }

    @Override
    public Request updateRequest(Request request) {
        return entityManager.merge(request);
    }

    @Override
    public Request getRequestById(Long id) {
        return entityManager.find(Request.class, id);
    }

    @Override
    public List<Request> getRequestsByUserId(Long userId) {
        TypedQuery<Request> query = entityManager.createQuery("select r from Request r where r.user.id = :userId", Request.class);
        return query.setParameter("userId", userId).getResultList();
    }

    @Override
    public List<Request> getAllRequests() {
        TypedQuery<Request> query = entityManager.createQuery("select r from Request r", Request.class);
        return query.getResultList();
    }

    @Override
    public List<Request> getRequestsByTrainingId(Long trainingId) {
        TypedQuery<Request> query = entityManager.createQuery("select r from Request r where r.training.id = :trainingId", Request.class);
        return query.setParameter("trainingId", trainingId).getResultList();
    }
}
