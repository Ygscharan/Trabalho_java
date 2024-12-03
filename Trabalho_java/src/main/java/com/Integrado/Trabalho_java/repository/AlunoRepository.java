package com. Integrado. Trabalho_java. repository;


import com.Integrado.Trabalho_java.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}