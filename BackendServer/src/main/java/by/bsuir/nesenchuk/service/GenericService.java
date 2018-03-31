package by.bsuir.nesenchuk.service;

import by.bsuir.nesenchuk.dto.DTO;

import java.io.Serializable;

public interface GenericService<D extends DTO, K extends Serializable> {
    /**
     * Adds an instance of some dto class to the data storage.
     *
     * @param dto an instance of some dto class
     * @return an added instance of some dto class
     */
    D add(D dto);

    /**
     * Updates an instance of some dto class to the data storage.
     *
     * @param dto an instance of some dto class
     * @return an updated instance of some dto class
     */
    D update(D dto);

    /**
     * Deletes an instance of some dto with the given ID from the data storage.
     *
     * @param id an id of the deleting instance
     */
    void delete(K id);

    /**
     * Gets a certain instance of some dto by the given ID.
     *
     * @param id an id of the needed instance
     * @return a certain instance of some dto
     */
    D getById(K id);
}
