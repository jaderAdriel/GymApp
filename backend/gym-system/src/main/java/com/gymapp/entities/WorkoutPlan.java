package com.gymapp.entities;

import com.gymapp.dtos.workoutPlan.WorkoutPlanExerciseResponseDTO;
import com.gymapp.dtos.workoutPlan.WorkoutPlanResponseDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_workout_plans")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;

    @OneToMany(mappedBy = "workoutPlan", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<WorkoutPlanExercise> exercises = new ArrayList<>();

    public WorkoutPlanResponseDTO toResponseDTO() {
        List<WorkoutPlanExerciseResponseDTO> workoutPlanExerciseResponseDTOS = exercises.stream()
                .map(x -> x.toResponseDTO())
                .toList();

        return new WorkoutPlanResponseDTO(id, name, description, createdAt, workoutPlanExerciseResponseDTOS);
    }
}
