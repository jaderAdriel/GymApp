package com.gymapp.services;
import com.gymapp.dtos.exercise.ExerciseRequestDTO;
import com.gymapp.entities.Exercise;
import com.gymapp.entities.WorkoutPlan;
import org.springframework.stereotype.Service;


@Service
public class WorkoutPlanExercise {

    private final WorkoutPlanExercise workoutPlanExercise;

    public WorkoutPlanExercise(WorkoutPlanExercise workoutPlanExercise) {
        this.workoutPlanExercise = workoutPlanExercise;
    }

    public Exercise insert(ExerciseRequestDTO exerciseRequestDTO, WorkoutPlan workoutPlan) {
        Exercise newExercise = exerciseRequestDTO.toExercise();
        return exerciseRepository.save(newExercise);
    }
}
