package br.edu.unoesc.operacaoservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.operacaoservice.common.model.Requisicao;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.ICrudRepository;

@Repository
public interface RequisicaoRepository extends ICrudRepository<Requisicao, Long> {
}
