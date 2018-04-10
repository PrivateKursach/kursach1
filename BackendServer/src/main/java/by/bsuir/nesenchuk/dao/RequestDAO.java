package by.bsuir.nesenchuk.dao;

import by.bsuir.nesenchuk.entity.Request;

import java.util.List;

public interface RequestDAO {
    Request createRequest(Request request);
    Request updateRequest(Request request);
    Request getRequestById(Long id);
    List<Request> getRequestsByUserId(Long userId);
    List<Request> getAllRequests();
}
