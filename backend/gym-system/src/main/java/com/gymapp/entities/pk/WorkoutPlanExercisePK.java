package com.gymapp.entities.pk;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class WorkoutPlanExercisePK implements Serializable {
    private long workoutPlanId;
    private long exerciseId;
}
