package com.gymapp.dtos.workoutPlan;

import com.gymapp.entities.WorkoutPlanExercise;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class WorkoutPlanExerciseRequestDTO {

    @NotNull
    Long exerciseId;

    @NotNull
    String setsDescription;

    long workoutPlanId;

    public WorkoutPlanExercise toWorkoutPlanExercise() {
        WorkoutPlanExercise obj = new WorkoutPlanExercise();

        obj.setSetsDescription(setsDescription);
        return obj;
    }
}
