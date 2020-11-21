package br.edu.unoesc.operacaoservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.operacaoservice.common.model.Prioridade;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.IIdentityRepository;

@Repository
public interface PrioridadeRepository extends IIdentityRepository<Prioridade, Long> {
}
