package by.bsuir.nesenchuk.service.impl;

import by.bsuir.nesenchuk.dao.RequestDAO;
import by.bsuir.nesenchuk.entity.Request;
import by.bsuir.nesenchuk.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestDAO requestDAO;

    @Override
    public Request createRequest(Request request) {
        return requestDAO.createRequest(request);
    }

    @Override
    public Request updateRequest(Request request) {
        return requestDAO.updateRequest(request);
    }

    @Override
    public Request getRequestById(Long id) {
        return requestDAO.getRequestById(id);
    }

    @Override
    public List<Request> getRequestsByUserId(Long userId) {
        return requestDAO.getRequestsByUserId(userId);
    }

    @Override
    public List<Request> getAllRequests() {
        return requestDAO.getAllRequests();
    }
}
