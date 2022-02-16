package org.senai.devinhouse.cloudgames.repository;

import org.senai.devinhouse.cloudgames.model.Genero;
import org.senai.devinhouse.cloudgames.model.Jogo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends PagingAndSortingRepository<Jogo, Long>{
    @Query(value = "SELECT * FROM lista2.jogo WHERE genero = :genero ORDER BY nome", nativeQuery = true)
    List<Jogo> findByGenero(String genero);
}
