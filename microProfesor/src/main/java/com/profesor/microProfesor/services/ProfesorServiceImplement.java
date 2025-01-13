package com.profesor.microProfesor.services;

import com.profesor.microProfesor.model.entity.Profesor;
import com.profesor.microProfesor.repositories.ProfesorRepository;
import java.util.List;
import java.lang.StackWalker.Option;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImplement implements ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> findAll() {
        return (List<Profesor>) profesorRepository.findAll();
    }

    @Override 
    public Optional<Profesor> findById(Long id) {
        return profesorRepository.findById(id);
    }
    @Override 
    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }
    @Override
    public void deleteById(Long id) {
        profesorRepository.deleteById(id);
    }
}
