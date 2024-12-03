package com.Integrado.Trabalho_java.repository;

import com.Integrado.Trabalho_java.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}