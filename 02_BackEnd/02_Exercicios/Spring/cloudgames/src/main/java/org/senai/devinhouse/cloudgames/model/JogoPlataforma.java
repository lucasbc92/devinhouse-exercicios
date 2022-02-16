package org.senai.devinhouse.cloudgames.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "jogo_plataforma")
public class JogoPlataforma {
    @EmbeddedId
    private JogoPlataformaKey id;

    @ManyToOne
    @MapsId("idJogo")
    @JoinColumn(name = "id_jogo")
    private Jogo jogo;

    @ManyToOne
    @MapsId("idPlataforma")
    @JoinColumn(name = "id_plataforma")
    private Plataforma plataforma;

    @Column(name = "dt_lancamento")
    private LocalDate dataLancamento;

    public JogoPlataformaKey getId() {
        return id;
    }

    public void setId(JogoPlataformaKey id) {
        this.id = id;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return "JogoPlataforma{" +
                "id=" + id +
                ", jogo=" + jogo +
                ", plataforma=" + plataforma +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}
