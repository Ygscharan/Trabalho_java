package com.Integrado.Trabalho_java.controller;

import com.Integrado.Trabalho_java.model.Professor;
import com.Integrado.Trabalho_java.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public Professor save(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> update(@PathVariable Long id, @RequestBody Professor professorAtualizado) {
        return professorRepository.findById(id)
                .map(professor -> {
                    professor.setNome(professorAtualizado.getNome());
                    professor.setEmail(professorAtualizado.getEmail());
                    professor.setTelefone(professorAtualizado.getTelefone());
                    professor.setEspecialidade(professorAtualizado.getEspecialidade());
                    return ResponseEntity.ok(professorRepository.save(professor));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (professorRepository.existsById(id)) {
            professorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}