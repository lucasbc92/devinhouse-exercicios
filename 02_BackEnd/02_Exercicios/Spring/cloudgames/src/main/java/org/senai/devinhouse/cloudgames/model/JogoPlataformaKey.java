package org.senai.devinhouse.cloudgames.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class JogoPlataformaKey implements Serializable {
    @Column(name = "id_jogo")
    Long idJogo;

    @Column(name = "id_plataforma")
    Long idPlataforma;

    public JogoPlataformaKey(){

    }

    public JogoPlataformaKey(Long idJogo, Long idPlataforma){
        this.idJogo = idJogo;
        this.idPlataforma = idPlataforma;
    }

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//
//        if (o == null || getClass() != o.getClass())
//            return false;
//
//        JogoPlataformaKey that = (JogoPlataformaKey) o;
//        return Objects.equals(idJogo, that.idJogo) &&
//                Objects.equals(idPlataforma, that.idPlataforma);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(idJogo, idPlataforma);
//    }

    @Override
    public String toString() {
        return "JogoPlataformaKey{" +
                "idJogo=" + idJogo +
                ", idPlataforma=" + idPlataforma +
                '}';
    }
}
