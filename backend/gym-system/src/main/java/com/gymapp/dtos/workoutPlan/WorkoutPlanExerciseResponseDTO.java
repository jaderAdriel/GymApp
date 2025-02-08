package com.gymapp.dtos.workoutPlan;

import com.gymapp.entities.Exercise;
import com.gymapp.entities.pk.WorkoutPlanExercisePK;

public record WorkoutPlanExerciseResponseDTO( WorkoutPlanExercisePK id, Exercise exerciseDetails, String setsDescription) {
}
