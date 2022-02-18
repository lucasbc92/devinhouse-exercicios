package org.senai.devinhouse.cloudgames.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogo_ger")
    @SequenceGenerator(name = "jogo_ger", sequenceName = "jogo_seq")
    private Long id;

    private String nome;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "jogo", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Midia capa;

    @Enumerated(value = EnumType.STRING)
    private Genero genero;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jogo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JogoPlataforma> plataformas;

    @ManyToMany(mappedBy = "jogos")
    private List<Usuario> usuarios;

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

    public Midia getCapa() {
        return capa;
    }

    public void setCapa(Midia capa) {
        this.capa = capa;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<JogoPlataforma> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<JogoPlataforma> plataformas) {
        this.plataformas = plataformas;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", capa=" + capa +
                ", genero=" + genero +
                ", plataformas=" + plataformas +
                '}';
    }

    public String toStringLazyFriendly() {
        return "Jogo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                //", capa=" + capa +
                ", genero=" + genero +
                //", plataformas=" + plataformas +
                '}';
    }
}
