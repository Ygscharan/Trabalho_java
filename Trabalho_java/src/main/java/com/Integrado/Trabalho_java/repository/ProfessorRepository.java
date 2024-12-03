package com.Integrado.Trabalho_java.repository;

import com.Integrado.Trabalho_java.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}