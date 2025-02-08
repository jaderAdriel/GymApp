package com.gymapp.entities;

import com.gymapp.dtos.workoutPlan.WorkoutPlanExerciseResponseDTO;
import com.gymapp.entities.pk.WorkoutPlanExercisePK;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_workout_plan_exercises")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WorkoutPlanExercise{

    @EmbeddedId
    private WorkoutPlanExercisePK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("workoutPlanId")
    @JoinColumn(name = "workout_plan_id", nullable = false)
    private WorkoutPlan workoutPlan;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("exerciseId")
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column(nullable = false)
    private String setsDescription;

    public WorkoutPlanExerciseResponseDTO toResponseDTO() {
        return new WorkoutPlanExerciseResponseDTO(id, exercise, setsDescription);
    }
}
