package br.edu.unoesc.pessoaservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoaservice.business.common.service.EstadoService;
import br.edu.unoesc.pessoaservice.common.model.Estado;
import br.edu.unoesc.pessoaservice.persistence.repository.EstadoRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractCrudService;

@Service
public class EstadoServiceImpl extends AbstractCrudService<Estado, EstadoRepository> implements EstadoService {

}
