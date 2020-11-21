package br.edu.unoesc.operacaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.operacaoservice.business.common.service.EventoService;
import br.edu.unoesc.operacaoservice.common.model.Evento;
import br.edu.unoesc.operacaoservice.persistence.repository.EventoRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractCrudService;

@Service
public class EventoServiceImpl extends AbstractCrudService<Evento, EventoRepository> implements EventoService {
}
