package com.Integrado.Trabalho_java.repository;

import com.Integrado.Trabalho_java.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

    List<Disciplina> findByCursoId(Long cursoId);
}
