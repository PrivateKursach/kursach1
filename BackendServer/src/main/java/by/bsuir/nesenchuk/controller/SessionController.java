package by.bsuir.nesenchuk.controller;

import by.bsuir.nesenchuk.converter.UserConverter;
import by.bsuir.nesenchuk.dto.UserDTO;
import by.bsuir.nesenchuk.service.UserService;
import by.bsuir.nesenchuk.validator.DTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private DTOValidator dtoValidator;

    @PostMapping
    public ResponseEntity<UserDTO> createSession(@RequestBody UserDTO loginDTO) {
        dtoValidator.validate(loginDTO);
        return ResponseEntity.ok(userConverter.convertToDTO(userService.login(loginDTO.getEmail(), loginDTO.getPassword())));
    }
}
