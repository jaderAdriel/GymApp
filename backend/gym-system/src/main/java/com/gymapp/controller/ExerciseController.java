package com.gymapp.controller;

import com.gymapp.dtos.exercise.CreateExerciseRequestDTO;
import com.gymapp.entities.Exercise;
import com.gymapp.services.ExerciseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;


    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> newExercise(@RequestBody @Valid CreateExerciseRequestDTO requestDTO) {

        exerciseService.insert(requestDTO);

        Map<String, String> content = Map.of("message", "Exercise registered with success");

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(content);

    }

    @GetMapping
    public ResponseEntity<List<Exercise>> getExercises() {
        List<Exercise> exercisesList = exerciseService.findAll();

        return ResponseEntity.ok().body(exercisesList);
    }


}
