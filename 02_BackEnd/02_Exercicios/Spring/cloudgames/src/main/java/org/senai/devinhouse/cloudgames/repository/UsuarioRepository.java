package org.senai.devinhouse.cloudgames.repository;

import org.senai.devinhouse.cloudgames.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM lista2.usuario WHERE LOWER(email) = LOWER(:email)", nativeQuery = true)
    List<Usuario> findByEmail(String email);

    @Query(value = "SELECT * FROM lista2.usuario u WHERE u.nome ILIKE %:str%", nativeQuery = true)
    List<Usuario> findByNomeContaining(String str);

    Usuario findFirstByEmailAndSenha(String email, String senha);

}
