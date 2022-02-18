package org.senai.devinhouse.cloudgames.repository;

import org.senai.devinhouse.cloudgames.model.JogoPlataforma;
import org.senai.devinhouse.cloudgames.model.JogoPlataformaKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoPlataformaRepository extends CrudRepository<JogoPlataforma, JogoPlataformaKey> {
}
