package com.gymapp.entities;

import com.gymapp.entities.pk.WorkoutPlanExercisePK;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_workout_plan_exercises")
public class WorkoutPlanExercise{

    @EmbeddedId
    private WorkoutPlanExercisePK id;

    @ManyToOne
    @MapsId("workoutPlanId")
    @JoinColumn(name = "workout_plan_id", nullable = false)
    private WorkoutPlan workoutPlan;

    @ManyToOne
    @MapsId("exerciseId")
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column(nullable = false)
    private String setsDescription;
}
