package com.Integrado.Trabalho_java.controller;

import com.Integrado.Trabalho_java.model.Turma;
import com.Integrado.Trabalho_java.repository.TurmaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping
    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Long id) { // Alterado de Integer para Long
        return turmaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Turma> save(@Valid @RequestBody Turma turma) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaRepository.save(turma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> update(@PathVariable Long id, @Valid @RequestBody Turma turma) { // Alterado de Integer para Long
        if (!turmaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        turma.setId(id);
        return ResponseEntity.ok(turmaRepository.save(turma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { // Alterado de Integer para Long
        if (!turmaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        turmaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
