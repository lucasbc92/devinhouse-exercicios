package org.senai.devinhouse.cloudgames.model;

import javax.persistence.*;

@Entity
public class Midia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "midia_ger")
    @SequenceGenerator(name = "midia_ger", sequenceName = "midia_seq")
    private Long id;

    private String url;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_jogo", referencedColumnName = "id")
    private Jogo jogo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public String toString() {
        return "Midia{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", jogo=" + jogo +
                '}';
    }
}
