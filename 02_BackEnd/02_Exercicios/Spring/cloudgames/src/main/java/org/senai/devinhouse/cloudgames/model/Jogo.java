package org.senai.devinhouse.cloudgames.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogo_ger")
    @SequenceGenerator(name = "jogo_ger", sequenceName = "jogo_seq")
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "jogo")
    private List<Midia> midias;

    @Enumerated(value = EnumType.STRING)
    private Genero genero;

    @OneToMany(mappedBy = "jogo")
    private Set<JogoPlataforma> plataformas;

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

    public List<Midia> getMidias() {
        return midias;
    }

    public void setMidias(List<Midia> midias) {
        this.midias = midias;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Set<JogoPlataforma> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(Set<JogoPlataforma> plataformas) {
        this.plataformas = plataformas;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                //", midias=" + midias +
                ", genero=" + genero +
                //", plataformas=" + plataformas +
                '}';
    }
}
