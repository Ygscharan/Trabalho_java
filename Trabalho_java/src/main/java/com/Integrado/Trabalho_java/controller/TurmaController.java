package com.Integrado.Trabalho_java.controller;

import com.Integrado.Trabalho_java.model.Aluno;
import com.Integrado.Trabalho_java.model.Turma;
import com.Integrado.Trabalho_java.repository.AlunoRepository;
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

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Long id) {
        return turmaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Turma> save(@Valid @RequestBody Turma turma) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaRepository.save(turma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> update(@PathVariable Long id, @Valid @RequestBody Turma turma) {
        if (!turmaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        turma.setId(id);
        return ResponseEntity.ok(turmaRepository.save(turma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!turmaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        turmaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/alunos")
    public List<Aluno> getAlunosByTurma(@PathVariable Long id) {
        return alunoRepository.findAlunosByTurmaId(id);
    }
}
