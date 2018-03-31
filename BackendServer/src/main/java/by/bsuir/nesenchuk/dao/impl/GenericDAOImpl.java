package by.bsuir.nesenchuk.dao.impl;

import by.bsuir.nesenchuk.dao.GenericDAO;
import by.bsuir.nesenchuk.entity.EntityObject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;


public abstract class GenericDAOImpl<E extends EntityObject, K extends Serializable> implements GenericDAO<E, K> {
    private Class<E> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public GenericDAOImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public E add(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public E update(E entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(K id) {
        E entity = entityManager.find(entityClass, id);
        entityManager.remove(entity);
    }

    @Override
    public E getById(K id) {
        return entityManager.find(entityClass, id);
    }
}
