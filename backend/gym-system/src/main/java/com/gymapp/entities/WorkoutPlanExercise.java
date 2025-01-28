package com.gymapp.entities;

import com.gymapp.entities.pk.WorkoutPlanExercisePK;
import jakarta.persistence.*;

@Entity
public class WorkoutPlanExercise{

    @EmbeddedId
    private WorkoutPlanExercisePK id;

    @ManyToOne
    @MapsId("workoutPlanId")
    @JoinColumn(name = "workout_plan_id")
    private WorkoutPlan workoutPlan;

    @ManyToOne
    @MapsId("exerciseId")
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    private String weight;
    private Integer sets;
}
