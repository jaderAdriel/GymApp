package com.gymapp.dtos.exercise;

import com.gymapp.entities.Exercise;
import com.gymapp.entities.MuscleGroup;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CreateExerciseRequestDTO {

    @NotNull(message = "Name is required")
    String name;

    @NotNull(message = "description is required")
    String description;

    Set<MuscleGroup> workedMuscleGroup;

    String movementExampleUrl;

    public Exercise toExercise() {

        Exercise newExercise = new Exercise();

        newExercise.setName(name);
        newExercise.setDescription(description);
        newExercise.setWorkedMuscleGroup(workedMuscleGroup);
        newExercise.setMovementExampleUrl(movementExampleUrl);

        return newExercise;
    }

}
