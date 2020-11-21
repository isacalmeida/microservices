package br.edu.unoesc.acessoservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.acessoservice.common.model.TipoServico;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.IIdentityRepository;

@Repository
public interface TipoServicoRepository extends IIdentityRepository<TipoServico, Long> {
}
