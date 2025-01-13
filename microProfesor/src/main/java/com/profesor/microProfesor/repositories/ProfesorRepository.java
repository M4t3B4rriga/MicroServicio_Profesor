package com.profesor.microProfesor.repositories;

import com.profesor.microProfesor.model.entity.Profesor;
import org.springframework.data.repository.CrudRepository;

public interface ProfesorRepository extends CrudRepository<Profesor, Long> {
}