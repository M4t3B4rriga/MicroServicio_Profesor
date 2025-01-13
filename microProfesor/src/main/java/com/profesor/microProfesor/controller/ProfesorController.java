package com.profesor.microProfesor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profesor.microProfesor.model.entity.Profesor;
import com.profesor.microProfesor.services.ProfesorService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RestController 
@RequestMapping("/api/profesor")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Profesor profesor, BindingResult result) {
        if (result.hasErrors()) {
            Map <String, Object> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errores);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(profesorService.save(profesor));
    }
    @GetMapping
    public List<Profesor> listar() {
        return profesorService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        Optional<Profesor> profesor = profesorService.findById(id);
        if (profesor.isEmpty()) {
            return ResponseEntity.ok().body(profesor.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Profesor profesor) {
        Optional<Profesor> profesorExistente = profesorService.findById(id);
        if (profesorExistente.isPresent()) {
            Profesor profesorActual=profesorExistente.get();
            profesorActual.setNombre(profesor.getNombre());
            profesorActual.setEmail(profesor.getEmail());
            profesorActual.setSueldo(profesor.getSueldo());

            return ResponseEntity.ok().body(profesorService.save(profesorActual));
        }
        
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Profesor> profesor = profesorService.findById(id);
        if (profesor.isPresent()) {
            profesorService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}
