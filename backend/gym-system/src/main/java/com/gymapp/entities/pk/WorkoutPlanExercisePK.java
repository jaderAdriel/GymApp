package com.gymapp.entities.pk;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutPlanExercisePK implements Serializable {

    @EqualsAndHashCode.Include
    private long workoutPlanId;

    @EqualsAndHashCode.Include
    private long exerciseId;
}
