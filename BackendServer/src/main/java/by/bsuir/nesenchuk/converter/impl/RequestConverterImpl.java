package by.bsuir.nesenchuk.converter.impl;

import by.bsuir.nesenchuk.converter.RequestConverter;
import by.bsuir.nesenchuk.converter.TrainingConverter;
import by.bsuir.nesenchuk.converter.UserConverter;
import by.bsuir.nesenchuk.dto.RequestDTO;
import by.bsuir.nesenchuk.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RequestConverterImpl implements RequestConverter {

    @Autowired
    private UserConverter userConverter;
    @Autowired
    private TrainingConverter trainingConverter;

    @Override
    public RequestDTO convertToDTO(Request request) {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setId(request.getId());
        requestDTO.setUser(userConverter.convertToDTO(request.getUser()));
        requestDTO.setTraining(trainingConverter.convertToDTO(request.getTraining()));
        requestDTO.setStatus(request.getStatus());
        requestDTO.setRating(request.getRating());
        requestDTO.setDateCreated(request.getDateCreated());
        return requestDTO;
    }

    @Override
    public Request convertToEntity(RequestDTO requestDTO) {
        Request request = new Request();
        request.setId(requestDTO.getId());
        request.setUser(userConverter.convertToEntity(requestDTO.getUser()));
        request.setTraining(trainingConverter.convertToEntity(requestDTO.getTraining()));
        request.setStatus(requestDTO.getStatus());
        request.setRating(requestDTO.getRating());
        request.setDateCreated(requestDTO.getDateCreated());
        return request;
    }

    @Override
    public List<RequestDTO> convertToDTOList(List<Request> requests) {
        List<RequestDTO> requestDTOList = new ArrayList<>(requests.size());
        requestDTOList.addAll(requests.stream().map(this::convertToDTO).collect(Collectors.toList()));
        return requestDTOList;
    }
}
