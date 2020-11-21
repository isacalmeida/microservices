package br.edu.unoesc.operacaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.operacaoservice.business.common.service.ProblemaService;
import br.edu.unoesc.operacaoservice.common.model.Problema;
import br.edu.unoesc.operacaoservice.persistence.repository.ProblemaRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractCrudService;

@Service
public class ProblemaServiceImpl extends AbstractCrudService<Problema, ProblemaRepository> implements ProblemaService {
}
