package com.gymapp.services;

import com.gymapp.dtos.workoutPlan.WorkoutPlanExerciseRequestDTO;
import com.gymapp.dtos.workoutPlan.WorkoutPlanRequestDTO;
import com.gymapp.dtos.workoutPlan.WorkoutPlanResponseDTO;
import com.gymapp.entities.WorkoutPlan;
import com.gymapp.entities.WorkoutPlanExercise;
import com.gymapp.entities.pk.WorkoutPlanExercisePK;
import com.gymapp.repositories.WorkoutPlanRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WorkoutPlanService {

    private final WorkoutPlanRepository workoutPlanRepository;
    private final ExerciseService exerciseService;

    public WorkoutPlanService(WorkoutPlanRepository workoutPlanRepository, ExerciseService exerciseService) {
        this.workoutPlanRepository = workoutPlanRepository;
        this.exerciseService = exerciseService;
    }

    @Transactional
    public WorkoutPlan insert(WorkoutPlanRequestDTO workoutPlanRequestDTO) {
        WorkoutPlan workoutPlan = workoutPlanRequestDTO.toWorkoutPlan();

        workoutPlan =  workoutPlanRepository.save(workoutPlan);

        List<WorkoutPlanExercise> workoutPlanExercises = new ArrayList<>();

        for (WorkoutPlanExerciseRequestDTO dto: workoutPlanRequestDTO.getExercises()) {

            WorkoutPlanExercise workoutPlanExercise = dto.toWorkoutPlanExercise();

            Long exerciseId = dto.getExerciseId();
            workoutPlanExercise.setExercise(exerciseService.findById(exerciseId));

            workoutPlanExercise.setWorkoutPlan(workoutPlan);
            workoutPlanExercise.setId(new WorkoutPlanExercisePK(exerciseId, workoutPlan.getId()));

            workoutPlanExercises.add(workoutPlanExercise);
        }

        workoutPlan.setExercises(workoutPlanExercises);

        return workoutPlan;
    }

    public List<WorkoutPlanResponseDTO> findAll() {
        List<WorkoutPlan> workoutsPlan = workoutPlanRepository.findAll();

        return workoutsPlan.stream()
                .map(WorkoutPlan::toResponseDTO)
                .toList();
    }
}
