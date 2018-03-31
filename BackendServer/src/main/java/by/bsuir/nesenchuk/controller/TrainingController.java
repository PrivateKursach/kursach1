package by.bsuir.nesenchuk.controller;

import by.bsuir.nesenchuk.dto.TrainingDTO;
import by.bsuir.nesenchuk.service.TrainingService;
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

    @GetMapping
    public ResponseEntity<List<TrainingDTO>> getTrainings() {
        return ResponseEntity.ok(trainingService.getTrainings());
    }
}
