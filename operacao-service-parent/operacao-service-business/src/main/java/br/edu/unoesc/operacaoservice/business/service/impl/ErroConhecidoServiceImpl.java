package br.edu.unoesc.operacaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.operacaoservice.business.common.service.ErroConhecidoService;
import br.edu.unoesc.operacaoservice.common.model.ErroConhecido;
import br.edu.unoesc.operacaoservice.persistence.repository.ErroConhecidoRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractCrudService;

@Service
public class ErroConhecidoServiceImpl extends AbstractCrudService<ErroConhecido, ErroConhecidoRepository> implements ErroConhecidoService {
}
