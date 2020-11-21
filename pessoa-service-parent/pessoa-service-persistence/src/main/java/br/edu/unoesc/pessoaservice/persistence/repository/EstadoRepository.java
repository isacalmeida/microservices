package br.edu.unoesc.pessoaservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.common.model.Estado;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.ICrudRepository;

@Repository
public interface EstadoRepository extends ICrudRepository<Estado, Long> {

	Estado findBySiglaAndIsExcluido(String sigla, Boolean excluido);
}
