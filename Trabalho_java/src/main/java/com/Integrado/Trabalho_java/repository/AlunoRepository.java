package com.Integrado.Trabalho_java.repository;

import com.Integrado.Trabalho_java.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("SELECT a FROM Aluno a JOIN a.matriculas m WHERE m.turma.id = :turmaId")
    List<Aluno> findAlunosByTurmaId(@Param("turmaId") Long turmaId);
}
