package by.bsuir.nesenchuk.controller;

import by.bsuir.nesenchuk.converter.TrainingTypeConverter;
import by.bsuir.nesenchuk.dto.TrainingTypeDTO;
import by.bsuir.nesenchuk.entity.TrainingType;
import by.bsuir.nesenchuk.service.TrainingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/training-types")
public class TrainingTypeController {

    @Autowired
    private TrainingTypeService trainingTypeService;
    @Autowired
    private TrainingTypeConverter trainingTypeConverter;

    @PostMapping
    public ResponseEntity<TrainingTypeDTO> createTrainingType(@RequestBody TrainingTypeDTO trainingTypeDTO) {
        TrainingType trainingType = trainingTypeConverter.convertToEntity(trainingTypeDTO);
        return ResponseEntity.ok(trainingTypeConverter.convertToDTO(trainingTypeService.createTrainingType(trainingType)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainingTypeDTO> updateTrainingType(@RequestBody TrainingTypeDTO trainingTypeDTO, @PathVariable Long id) {
        trainingTypeDTO.setId(id);
        TrainingType trainingType = trainingTypeConverter.convertToEntity(trainingTypeDTO);
        return ResponseEntity.ok(trainingTypeConverter.convertToDTO(trainingTypeService.updateTrainingType(trainingType)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainingType(@PathVariable Long id) {
        trainingTypeService.deleteTrainingType(id);
        return ResponseEntity.noContent().build();
    }
}
