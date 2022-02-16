package com.senai.devinhouse.springdata.repository;

import com.senai.devinhouse.springdata.model.Estudante;
import com.senai.devinhouse.springdata.model.EstudanteProjecao;
import com.senai.devinhouse.springdata.model.Genero;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface EstudanteRepository extends PagingAndSortingRepository<Estudante, Long>,
        JpaSpecificationExecutor<Estudante> {

    Optional<Estudante> findByNome(String nome);

    @Query("SELECT e FROM Estudante e WHERE e.idade > :idadePesquisada")
    List<Estudante> findPorIdade(Integer idadePesquisada);

    @Query(value = "select * from estudantes where nome like '%:letras%'", nativeQuery = true)
    List<Estudante> findByNomeContaining(String letras);

    @Query(value = "select nome, last_name as ultimoNome from estudantes where idade > :idade", nativeQuery = true)
    List<EstudanteProjecao> buscarPorIdadeProjecao(Integer idade);

    List<Estudante> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

    List<Estudante> findByIdadeLessThan(Integer idade);

    List<Estudante> findByGeneroIn(Collection<Genero> generos);

    List<Estudante> findByEnderecoNotNull();

    List<Estudante> findByEnderecoCidade(String cidade);


}
