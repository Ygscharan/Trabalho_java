package com.Integrado.Trabalho_java.repository;

import com.Integrado.Trabalho_java.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    @Query("SELECT n FROM Nota n WHERE n.matricula.id = :matriculaId")
    List<Nota> findByMatriculaId(@Param("matriculaId") Long matriculaId);

    @Query("SELECT n FROM Nota n WHERE n.disciplina.id = :disciplinaId")
    List<Nota> findByDisciplinaId(@Param("disciplinaId") Long disciplinaId);
}
