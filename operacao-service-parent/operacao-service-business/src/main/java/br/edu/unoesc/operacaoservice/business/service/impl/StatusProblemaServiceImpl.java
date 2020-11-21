package br.edu.unoesc.operacaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.operacaoservice.business.common.service.StatusProblemaService;
import br.edu.unoesc.operacaoservice.common.model.StatusProblema;
import br.edu.unoesc.operacaoservice.persistence.repository.StatusProblemaRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;

@Service
public class StatusProblemaServiceImpl extends AbstractIdentityService<StatusProblema, Long, StatusProblemaRepository> implements StatusProblemaService {
}
