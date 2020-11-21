package br.edu.unoesc.operacaoservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.operacaoservice.common.model.StatusIncidente;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.IIdentityRepository;

@Repository
public interface StatusIncidenteRepository extends IIdentityRepository<StatusIncidente, Long> {
}
