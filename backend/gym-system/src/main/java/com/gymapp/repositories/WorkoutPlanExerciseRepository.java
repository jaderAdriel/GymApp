package com.gymapp.repositories;

import com.gymapp.entities.WorkoutPlanExercise;
import com.gymapp.entities.pk.WorkoutPlanExercisePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutPlanExerciseRepository extends JpaRepository<WorkoutPlanExercise, WorkoutPlanExercisePK> {
}
