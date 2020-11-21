package br.edu.unoesc.operacaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.operacaoservice.business.common.service.PrioridadeService;
import br.edu.unoesc.operacaoservice.common.model.Prioridade;
import br.edu.unoesc.operacaoservice.persistence.repository.PrioridadeRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;

@Service
public class PrioridadeServiceImpl extends AbstractIdentityService<Prioridade, Long, PrioridadeRepository> implements PrioridadeService {
}
