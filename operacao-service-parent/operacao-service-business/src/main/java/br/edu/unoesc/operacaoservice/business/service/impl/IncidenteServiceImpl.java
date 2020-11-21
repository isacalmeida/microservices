package br.edu.unoesc.operacaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.operacaoservice.business.common.service.IncidenteService;
import br.edu.unoesc.operacaoservice.common.model.Incidente;
import br.edu.unoesc.operacaoservice.persistence.repository.IncidenteRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractCrudService;

@Service
public class IncidenteServiceImpl extends AbstractCrudService<Incidente, IncidenteRepository> implements IncidenteService {
}
