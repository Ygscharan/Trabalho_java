package com.Integrado.Trabalho_java.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "turmas")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer ano;

    @NotNull
    @Min(1)
    @Max(2)
    private Integer semestre;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull Integer getAno() {
        return ano;
    }

    public void setAno(@NotNull Integer ano) {
        this.ano = ano;
    }

    public @NotNull @Min(1) @Max(2) Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(@NotNull @Min(1) @Max(2) Integer semestre) {
        this.semestre = semestre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}