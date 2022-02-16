package org.senai.devinhouse.cloudgames.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Plataforma {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plataforma_ger")
    @SequenceGenerator(name = "plataforma_ger", sequenceName = "plataforma_seq")
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "plataforma")
    private Set<JogoPlataforma> jogos;

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

    public Set<JogoPlataforma> getJogos() {
        return jogos;
    }

    public void setJogos(Set<JogoPlataforma> jogos) {
        this.jogos = jogos;
    }

    @Override
    public String toString() {
        return "Plataforma{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                //", jogos=" + jogos +
                '}';
    }
}
