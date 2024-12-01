package com.Integrado.Trabalho_java.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "professores")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String nome;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    @Size(max = 15)
    private String telefone;

    @Size(max = 100)
    private String especialidade;

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

    public @NotNull @Email @Size(max = 100) String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email @Size(max = 100) String email) {
        this.email = email;
    }

    public @Size(max = 15) String getTelefone() {
        return telefone;
    }

    public void setTelefone(@Size(max = 15) String telefone) {
        this.telefone = telefone;
    }

    public @Size(max = 100) String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(@Size(max = 100) String especialidade) {
        this.especialidade = especialidade;
    }
}
