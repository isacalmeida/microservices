package br.edu.unoesc.transicaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;
import br.edu.unoesc.transicaoservice.business.common.service.StatusMudancaService;
import br.edu.unoesc.transicaoservice.common.model.StatusMudanca;
import br.edu.unoesc.transicaoservice.persistence.repository.StatusMudancaRepository;

@Service
public class StatusMudancaServiceImpl extends AbstractIdentityService<StatusMudanca, Long, StatusMudancaRepository> implements StatusMudancaService {
}
