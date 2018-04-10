package by.bsuir.nesenchuk.service;

import by.bsuir.nesenchuk.entity.Request;

import java.util.List;

public interface RequestService {
    Request createRequest(Request request);
    Request updateRequest(Request request);
    Request getRequestById(Long id);
    List<Request> getRequestsByUserId(Long userId);
    List<Request> getAllRequests();
}
