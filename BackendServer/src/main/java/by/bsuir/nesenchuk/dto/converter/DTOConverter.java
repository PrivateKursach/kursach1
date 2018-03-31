package by.bsuir.nesenchuk.dto.converter;

import by.bsuir.nesenchuk.dto.DTO;
import by.bsuir.nesenchuk.entity.EntityObject;

import java.util.List;

public interface DTOConverter<E extends EntityObject, D extends DTO> {
    /**
     * Returns a DTO object from the EntityObject object.
     *
     * @param entity an instance of the EntityObject class
     * @return an instance of the DTO class
     */
    D getDto(E entity);

    /**
     * Returns a EntityObject object from the DTO object.
     *
     * @param dto an instance of the DTO class
     * @return an instance of the EntityObject class
     */
    E getEntity(D dto);

    /**
     * Returns a list of DTO objects from a list of entity object.
     *
     * @param entityList a list of entity objects
     * @return a list of DTO objects
     */
    List<D> getDtoList(List<E> entityList);
}
