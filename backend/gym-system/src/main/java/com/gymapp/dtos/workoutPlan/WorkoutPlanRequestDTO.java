package com.gymapp.dtos.workoutPlan;

import com.gymapp.entities.WorkoutPlan;
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

    @NotNull
    String name;

    @NotNull
    String description;

    @NotNull
    List<WorkoutPlanExerciseRequestDTO> exercises;

    public WorkoutPlan toWorkoutPlan() {
        WorkoutPlan obj = new WorkoutPlan();
        obj.setName(name);
        obj.setDescription(description);

        return obj;
    }
}
