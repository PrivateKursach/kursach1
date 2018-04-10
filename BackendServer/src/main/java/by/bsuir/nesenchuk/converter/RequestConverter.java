package by.bsuir.nesenchuk.converter;

import by.bsuir.nesenchuk.dto.RequestDTO;
import by.bsuir.nesenchuk.entity.Request;

import java.util.List;

public interface RequestConverter {
    RequestDTO convertToDTO(Request request);
    Request convertToEntity(RequestDTO requestDTO);
    List<RequestDTO> convertToDTOList(List<Request> requests);
}
