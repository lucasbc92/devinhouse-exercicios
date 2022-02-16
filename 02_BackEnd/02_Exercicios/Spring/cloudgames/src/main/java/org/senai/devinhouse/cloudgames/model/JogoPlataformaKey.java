package org.senai.devinhouse.cloudgames.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class JogoPlataformaKey implements Serializable {
    @Column(name = "id_jogo")
    Long idJogo;

    @Column(name = "id_plataforma")
    Long idPlataforma;

    public Long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Long idJogo) {
        this.idJogo = idJogo;
    }

    public Long getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Long idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    @Override
    public String toString() {
        return "JogoPlataformaKey{" +
                "idJogo=" + idJogo +
                ", idPlataforma=" + idPlataforma +
                '}';
    }
}
