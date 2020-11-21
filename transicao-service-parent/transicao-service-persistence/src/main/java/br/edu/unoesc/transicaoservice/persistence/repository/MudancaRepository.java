package br.edu.unoesc.transicaoservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.IMasterRepository;
import br.edu.unoesc.transicaoservice.common.model.Mudanca;

@Repository
public interface MudancaRepository extends IMasterRepository<Mudanca, Long> {
}
