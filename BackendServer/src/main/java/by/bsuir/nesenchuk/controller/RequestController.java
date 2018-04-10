package by.bsuir.nesenchuk.controller;

import by.bsuir.nesenchuk.converter.RequestConverter;
import by.bsuir.nesenchuk.dto.RequestDTO;
import by.bsuir.nesenchuk.entity.Request;
import by.bsuir.nesenchuk.service.RequestService;
import by.bsuir.nesenchuk.validator.DTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;
    @Autowired
    private RequestConverter requestConverter;
    @Autowired
    private DTOValidator dtoValidator;

    @GetMapping
    public ResponseEntity<List<RequestDTO>> getAllRequests() {
        return ResponseEntity.ok(requestConverter.convertToDTOList(requestService.getAllRequests()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestDTO> getRequestById(@PathVariable Long id) {
        return ResponseEntity.ok(requestConverter.convertToDTO(requestService.getRequestById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequestDTO> updateRequest(@RequestBody RequestDTO requestDTO, @PathVariable Long id) {
        requestDTO.setId(id);
        Request updatedRequest = requestService.updateRequest(requestConverter.convertToEntity(requestDTO));
        return ResponseEntity.ok(requestConverter.convertToDTO(updatedRequest));
    }
}
