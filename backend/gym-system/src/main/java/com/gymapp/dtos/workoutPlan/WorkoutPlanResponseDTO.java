package com.gymapp.dtos.workoutPlan;

import java.time.Instant;
import java.util.List;

public record WorkoutPlanResponseDTO(Long id, String name, String description, Instant createdAt, List<WorkoutPlanExerciseResponseDTO> exercises) {
}
