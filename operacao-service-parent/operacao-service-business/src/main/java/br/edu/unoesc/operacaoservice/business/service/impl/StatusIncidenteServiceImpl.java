package br.edu.unoesc.operacaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.operacaoservice.business.common.service.StatusIncidenteService;
import br.edu.unoesc.operacaoservice.common.model.StatusIncidente;
import br.edu.unoesc.operacaoservice.persistence.repository.StatusIncidenteRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;

@Service
public class StatusIncidenteServiceImpl extends AbstractIdentityService<StatusIncidente, Long, StatusIncidenteRepository> implements StatusIncidenteService {
}
