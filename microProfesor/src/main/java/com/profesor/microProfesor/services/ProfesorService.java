package com.profesor.microProfesor.services;

import java.util.List;
import java.util.Optional;

import com.profesor.microProfesor.model.entity.Profesor;

public interface ProfesorService {
    List<Profesor> findAll();
    Optional<Profesor> findById(Long id);
    Profesor save(Profesor profesor);
    void deleteById(Long id);
}
