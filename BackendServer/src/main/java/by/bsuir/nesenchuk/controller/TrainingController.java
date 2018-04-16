package by.bsuir.nesenchuk.controller;

import by.bsuir.nesenchuk.converter.TrainingConverter;
import by.bsuir.nesenchuk.converter.TrainingTypeConverter;
import by.bsuir.nesenchuk.dto.TrainingDTO;
import by.bsuir.nesenchuk.dto.TrainingStatsDTO;
import by.bsuir.nesenchuk.dto.TrainingTypeDTO;
import by.bsuir.nesenchuk.entity.Training;
import by.bsuir.nesenchuk.service.TrainingService;
import by.bsuir.nesenchuk.service.TrainingStatsService;
import by.bsuir.nesenchuk.service.TrainingTypeService;
import by.bsuir.nesenchuk.validator.DTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private TrainingStatsService trainingStatsService;
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

    @PostMapping
    public ResponseEntity<TrainingDTO> createTraining(@RequestBody TrainingDTO trainingDTO) {
        Training createdTraining = trainingService.createTraining(trainingConverter.convertToEntity(trainingDTO));
        return ResponseEntity.ok(trainingConverter.convertToDTO(createdTraining));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingDTO> updateTraining(@RequestBody TrainingDTO trainingDTO, @PathVariable Long id) {
        trainingDTO.setId(id);
        Training updatedTraining = trainingService.updateTraining(trainingConverter.convertToEntity(trainingDTO));
        return ResponseEntity.ok(trainingConverter.convertToDTO(updatedTraining));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Long id) {
        trainingService.deleteTraining(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingDTO> getTrainingById(@PathVariable Long id) {
        return ResponseEntity.ok(trainingConverter.convertToDTO(trainingService.getTrainingById(id)));
    }

    @GetMapping("/{id}/stats")
    public ResponseEntity<TrainingStatsDTO> getStatsById(@PathVariable Long id) {
        return ResponseEntity.ok(trainingStatsService.getStats(id));
    }
}
