package com.gymapp.services;
import com.gymapp.dtos.exercise.ExerciseRequestDTO;
import com.gymapp.entities.Exercise;
import com.gymapp.repositories.ExerciseRepository;
import org.springframework.stereotype.Service;


@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise inserExercise(ExerciseRequestDTO exerciseRequestDTO) {
        Exercise newExercise = exerciseRequestDTO.toExercise();
        return exerciseRepository.save(newExercise);
    }
}
