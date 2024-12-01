package com.Integrado.Trabalho_java.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String nome;

    @NotNull
    @Size(max = 20)
    @Column(unique = true)
    private String codigo;

    @NotNull
    private Integer cargaHoraria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull @Size(max = 100) String getNome() {
        return nome;
    }

    public void setNome(@NotNull @Size(max = 100) String nome) {
        this.nome = nome;
    }

    public @NotNull @Size(max = 20) String getCodigo() {
        return codigo;
    }

    public void setCodigo(@NotNull @Size(max = 20) String codigo) {
        this.codigo = codigo;
    }

    public @NotNull Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(@NotNull Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}



