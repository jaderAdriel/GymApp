package com.gymapp.controller;

import com.gymapp.dtos.workoutPlan.WorkoutPlanRequestDTO;
import com.gymapp.dtos.workoutPlan.WorkoutPlanResponseDTO;
import com.gymapp.entities.WorkoutPlan;
import com.gymapp.services.WorkoutPlanService;
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
@RequestMapping("/workoutplan")
public class WorkoutPlanController {

    private final WorkoutPlanService workoutPlanService;

    public WorkoutPlanController(WorkoutPlanService workoutPlanService) {
        this.workoutPlanService = workoutPlanService;
    }

    @PostMapping
    public ResponseEntity<Map<String,String>> newWorkoutPlan(@RequestBody @Valid WorkoutPlanRequestDTO requestDTO) {
        workoutPlanService.insert(requestDTO);

        Map<String, String> content = Map.of("message", "Workout plan registered with success");

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(content);
    }

    @GetMapping
    public ResponseEntity<List<WorkoutPlanResponseDTO>> getWorkoutPlans() {
        List<WorkoutPlanResponseDTO> workoutPlans = workoutPlanService.findAll();

        return ResponseEntity.ok().body(workoutPlans);
    }
}
