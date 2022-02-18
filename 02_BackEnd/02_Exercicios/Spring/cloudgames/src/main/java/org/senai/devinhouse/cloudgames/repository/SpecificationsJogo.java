package org.senai.devinhouse.cloudgames.repository;

import org.senai.devinhouse.cloudgames.model.Genero;
import org.senai.devinhouse.cloudgames.model.Jogo;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationsJogo {

    public static Specification<Jogo> nome(String nome) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<Jogo> genero(Genero genero) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("genero"), genero);
    }
}
