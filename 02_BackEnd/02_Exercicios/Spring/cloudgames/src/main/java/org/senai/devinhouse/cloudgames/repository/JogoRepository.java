package org.senai.devinhouse.cloudgames.repository;

import org.senai.devinhouse.cloudgames.model.Genero;
import org.senai.devinhouse.cloudgames.model.Jogo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JogoRepository extends PagingAndSortingRepository<Jogo, Long>, JpaSpecificationExecutor<Jogo> {
    @Query(value = "SELECT j FROM Jogo j LEFT JOIN FETCH j.capa LEFT JOIN FETCH j.plataformas WHERE j.genero = :genero ORDER BY j.nome")
    List<Jogo> findByGenero(Genero genero);

    @Query(value = "SELECT j FROM Jogo j LEFT JOIN FETCH j.capa LEFT JOIN FETCH j.plataformas WHERE j.id = :id")
    Optional<Jogo> findById(Long id);

    @Query("SELECT j FROM Jogo j FETCH ALL PROPERTIES ")
    List<Jogo> findAllWithCapaAndPlataformas();

//    @Query(value = "SELECT * FROM lista2.jogo j LEFT JOIN lista2.midia m ON j.id = m.id_jogo LEFT JOIN lista2.jogo_plataforma jp ON j.id = jp.id_jogo", nativeQuery = true)
    @Query("FROM Jogo j FETCH ALL PROPERTIES")
    Page<Jogo> search(Pageable pageable);
}
