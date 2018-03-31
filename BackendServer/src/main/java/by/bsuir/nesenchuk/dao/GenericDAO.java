package by.bsuir.nesenchuk.dao;

import by.bsuir.nesenchuk.entity.EntityObject;

import java.io.Serializable;

public interface GenericDAO<E extends EntityObject, K extends Serializable> {

    /**
     * Adds an instance of some entity class to the data storage.
     *
     * @param entity an instance of some entity
     * @return an added instance of some entity
     */
    E add(E entity);

    /**
     * Updates an instance of some entity in the data storage.
     *
     * @param entity an instance of some entity
     * @return an updated instance of some entity
     */
    E update(E entity);

    /**
     * Deletes an instance of some entity with the given ID from the data storage.
     *
     * @param id an id of the deleting instance
     */
    void delete(K id);

    /**
     * Gets a certain instance of some entity by the given ID.
     *
     * @param id an id of the needed instance
     * @return a certain instance of some entity
     */
    E getById(K id);
}
