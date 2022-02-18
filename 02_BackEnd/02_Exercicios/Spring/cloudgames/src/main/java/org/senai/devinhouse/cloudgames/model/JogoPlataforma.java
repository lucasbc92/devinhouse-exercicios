package org.senai.devinhouse.cloudgames.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

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

    public JogoPlataforma(){

    }

    public JogoPlataforma(Jogo jogo, Plataforma plataforma) {
        this.jogo = jogo;
        this.plataforma = plataforma;
        this.id = new JogoPlataformaKey(jogo.getId(), plataforma.getId());
    }

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//
//        if (o == null || getClass() != o.getClass())
//            return false;
//
//        JogoPlataforma that = (JogoPlataforma) o;
//        return Objects.equals(jogo, that.jogo) &&
//                Objects.equals(plataforma, that.plataforma);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(jogo, plataforma);
//    }

    @Override
    public String toString() {
        return "JogoPlataforma{" +
                "id=" + id +
                //", jogo=" + jogo +
                ", plataforma=" + plataforma +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}
