package br.edu.unoesc.operacaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.operacaoservice.business.common.service.StatusEventoService;
import br.edu.unoesc.operacaoservice.common.model.StatusEvento;
import br.edu.unoesc.operacaoservice.persistence.repository.StatusEventoRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;

@Service
public class StatusEventoServiceImpl extends AbstractIdentityService<StatusEvento, Long, StatusEventoRepository> implements StatusEventoService {
}
