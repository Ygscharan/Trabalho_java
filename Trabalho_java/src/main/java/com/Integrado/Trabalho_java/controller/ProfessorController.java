package com.Integrado.Trabalho_java.controller;

import com.Integrado.Trabalho_java.model.Professor;
import com.Integrado.Trabalho_java.repository.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Integer id) {
        return professorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Professor> save(@Valid @RequestBody Professor professor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorRepository.save(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> update(@PathVariable Integer id, @Valid @RequestBody Professor professor) {
        if (!professorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        professor.setId(id);
        return ResponseEntity.ok(professorRepository.save(professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!professorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        professorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}