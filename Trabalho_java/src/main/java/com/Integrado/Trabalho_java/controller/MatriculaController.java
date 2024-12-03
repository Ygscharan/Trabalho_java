package com.Integrado.Trabalho_java.controller;

import com.Integrado.Trabalho_java.model.Matricula;
import com.Integrado.Trabalho_java.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @GetMapping
    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> findById(@PathVariable Long id) {
        return matriculaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Matricula save(@RequestBody Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matricula> update(@PathVariable Long id, @RequestBody Matricula matriculaAtualizada) {
        return matriculaRepository.findById(id)
                .map(matricula -> {
                    matricula.setAluno(matriculaAtualizada.getAluno());
                    matricula.setTurma(matriculaAtualizada.getTurma());
                    return ResponseEntity.ok(matriculaRepository.save(matricula));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (matriculaRepository.existsById(id)) {
            matriculaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
