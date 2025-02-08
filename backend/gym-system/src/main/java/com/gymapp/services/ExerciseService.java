package com.gymapp.services;
import com.gymapp.dtos.exercise.CreateExerciseRequestDTO;
import com.gymapp.entities.Exercise;
import com.gymapp.repositories.ExerciseRepository;
import com.gymapp.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise insert(CreateExerciseRequestDTO exerciseRequestDTO) {
        Exercise newExercise = exerciseRequestDTO.toExercise();
        return exerciseRepository.save(newExercise);
    }

    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    public Exercise findById(Long id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        return exercise.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
