package com.gymapp.dtos.workoutPlan;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class WorkoutPlanRequestDTO {

    String name;

    @NotNull
    String description;

    @NotNull
    List<WorkoutPlanExerciseRequestDTO> exercises;
}
