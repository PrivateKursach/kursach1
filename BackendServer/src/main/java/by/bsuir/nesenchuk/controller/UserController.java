package by.bsuir.nesenchuk.controller;

import by.bsuir.nesenchuk.converter.RequestConverter;
import by.bsuir.nesenchuk.converter.UserConverter;
import by.bsuir.nesenchuk.dto.RequestDTO;
import by.bsuir.nesenchuk.dto.UserDTO;
import by.bsuir.nesenchuk.entity.Request;
import by.bsuir.nesenchuk.service.RequestService;
import by.bsuir.nesenchuk.service.UserService;
import by.bsuir.nesenchuk.validator.DTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private DTOValidator dtoValidator;
    @Autowired
    private RequestService requestService;
    @Autowired
    private RequestConverter requestConverter;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        dtoValidator.validate(userDTO);
        return ResponseEntity.ok(userConverter.convertToDTO(userService.createUser(userConverter.convertToEntity(userDTO))));
    }

    @GetMapping("/{userId}/requests")
    public ResponseEntity<List<RequestDTO>> getRequests(@PathVariable Long userId) {
        return ResponseEntity.ok(requestConverter.convertToDTOList(requestService.getRequestsByUserId(userId)));
    }

    @PostMapping("/{userId}/requests")
    public ResponseEntity<RequestDTO> createRequest(@RequestBody RequestDTO requestDTO, @PathVariable Long userId) {
        requestDTO.getUser().setId(userId);
        Request createdRequest = requestService.createRequest(requestConverter.convertToEntity(requestDTO));
        return ResponseEntity.ok(requestConverter.convertToDTO(createdRequest));
    }
}
