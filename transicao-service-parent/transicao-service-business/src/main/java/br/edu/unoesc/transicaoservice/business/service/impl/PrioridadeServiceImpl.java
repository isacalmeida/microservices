package br.edu.unoesc.transicaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;
import br.edu.unoesc.transicaoservice.business.common.service.PrioridadeService;
import br.edu.unoesc.transicaoservice.common.model.Prioridade;
import br.edu.unoesc.transicaoservice.persistence.repository.PrioridadeRepository;

@Service
public class PrioridadeServiceImpl extends AbstractIdentityService<Prioridade, Long, PrioridadeRepository> implements PrioridadeService {
}
