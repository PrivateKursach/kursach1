package by.bsuir.nesenchuk.controller;

import by.bsuir.nesenchuk.converter.TrainingConverter;
import by.bsuir.nesenchuk.converter.TrainingTypeConverter;
import by.bsuir.nesenchuk.dto.TrainingDTO;
import by.bsuir.nesenchuk.dto.TrainingTypeDTO;
import by.bsuir.nesenchuk.service.TrainingService;
import by.bsuir.nesenchuk.service.TrainingTypeService;
import by.bsuir.nesenchuk.validator.DTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;
    @Autowired
    private TrainingTypeService trainingTypeService;
    @Autowired
    private TrainingConverter trainingConverter;
    @Autowired
    private TrainingTypeConverter trainingTypeConverter;
    @Autowired
    private DTOValidator dtoValidator;

    @GetMapping
    public ResponseEntity<List<TrainingDTO>> getTrainings() {
        return ResponseEntity.ok(trainingConverter.convertToDTOList(trainingService.getTrainings()));
    }

    @GetMapping("/types")
    public ResponseEntity<List<TrainingTypeDTO>> getAllTrainingTypes() {
        return ResponseEntity.ok(trainingTypeConverter.convertToDTOList(trainingTypeService.getTrainingTypes()));
    }

    @GetMapping("/trainers")
    public ResponseEntity<List<String>> getAllTrainers() {
        return ResponseEntity.ok(trainingService.getTrainers());
    }

    @GetMapping("/locations")
    public ResponseEntity<List<String>> getAllLocations() {
        return ResponseEntity.ok(trainingService.getLocations());
    }
}
