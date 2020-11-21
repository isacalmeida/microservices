package br.edu.unoesc.acessoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.acessoservice.business.common.service.ProgramaService;
import br.edu.unoesc.acessoservice.common.model.Programa;
import br.edu.unoesc.acessoservice.persistence.repository.ProgramaRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractCrudService;

@Service
public class ProgramaServiceImpl extends AbstractCrudService<Programa, ProgramaRepository> implements ProgramaService {
}
