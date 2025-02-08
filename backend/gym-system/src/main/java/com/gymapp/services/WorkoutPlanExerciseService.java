package com.gymapp.services;
import com.gymapp.dtos.workoutPlan.WorkoutPlanExerciseRequestDTO;
import com.gymapp.entities.Exercise;
import com.gymapp.entities.WorkoutPlan;
import com.gymapp.entities.WorkoutPlanExercise;
import com.gymapp.repositories.ExerciseRepository;
import com.gymapp.repositories.WorkoutPlanExerciseRepository;
import com.gymapp.repositories.WorkoutPlanRepository;
import com.gymapp.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class WorkoutPlanExerciseService {

    private final WorkoutPlanRepository workoutPlanRepository;
    private final WorkoutPlanExerciseRepository workoutPlanExerciseRepository;
    private final ExerciseRepository exerciseRepository;

    public WorkoutPlanExerciseService(WorkoutPlanRepository workoutPlanRepository, WorkoutPlanExerciseRepository workoutPlanExerciseRepository, ExerciseRepository exerciseRepository) {
        this.workoutPlanRepository = workoutPlanRepository;
        this.workoutPlanExerciseRepository = workoutPlanExerciseRepository;
        this.exerciseRepository = exerciseRepository;
    }
}
