package br.com.senai.semana10.salesapi.repository;

import br.com.senai.semana10.salesapi.entity.AlunoEntity;
import org.springframework.data.repository.CrudRepository;

public interface AlunoEntityRepository extends CrudRepository<AlunoEntity, Long> {
}
