package br.edu.unoesc.pessoaservice.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.common.model.Cidade;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.ICrudRepository;

@Repository
public interface CidadeRepository extends ICrudRepository<Cidade, Long> {

	Cidade findByEstado_SiglaAndDescricao(String sigla, String descricao);

	List<Cidade> findAllByEstado_IdEstado(Long idEstado);
}
