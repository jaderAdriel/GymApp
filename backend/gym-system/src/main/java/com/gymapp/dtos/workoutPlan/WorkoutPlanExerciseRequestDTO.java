package com.gymapp.dtos.workoutPlan;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class WorkoutPlanExerciseDTO {

    @NotNull
    Long exerciseId;

    @NotNull
    String setsDescription;

    Long workoutPlanId;
}
