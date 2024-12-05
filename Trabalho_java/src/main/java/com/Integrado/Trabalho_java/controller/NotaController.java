package com.Integrado.Trabalho_java.controller;

import com.Integrado.Trabalho_java.model.Nota;
import com.Integrado.Trabalho_java.repository.MatriculaRepository;
import com.Integrado.Trabalho_java.repository.DisciplinaRepository;
import com.Integrado.Trabalho_java.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api/notas")
public class NotaController {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;


    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarNota(@RequestBody Nota nota) {
        // Validação: Verificar se a matrícula e a disciplina existem
        if (!matriculaRepository.existsById(nota.getMatricula().getId())) {
            return ResponseEntity.badRequest().body("Matrícula não encontrada.");
        }

        if (!disciplinaRepository.existsById(nota.getDisciplina().getId())) {
            return ResponseEntity.badRequest().body("Disciplina não encontrada.");
        }

        Nota novaNota = notaRepository.save(nota);
        return ResponseEntity.ok(novaNota);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarNota(@PathVariable Long id, @RequestBody BigDecimal novaNota) {
        Optional<Nota> notaExistente = notaRepository.findById(id);

        if (notaExistente.isEmpty()) {
            return ResponseEntity.badRequest().body("Nota não encontrada.");
        }

        Nota nota = notaExistente.get();
        nota.setNota(novaNota);
        notaRepository.save(nota);

        return ResponseEntity.ok(nota);
    }
}
