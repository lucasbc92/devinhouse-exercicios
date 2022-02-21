package org.senai.devinhouse.semana10.cloudgames.model;

import javax.persistence.*;

@Entity
public class Plataforma {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plataforma_ger")
    @SequenceGenerator(name = "plataforma_ger", sequenceName = "plataforma_seq")
    private Long id;

    @Column(nullable = false)
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
