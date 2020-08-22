package br.edu.unoesc.pessoaservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoaservice.business.common.service.TipoContatoService;
import br.edu.unoesc.pessoaservice.common.model.TipoContato;
import br.edu.unoesc.pessoaservice.persistence.repository.TipoContatoRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;

@Service
public class TipoContatoServiceImpl extends AbstractIdentityService<TipoContato, Long, TipoContatoRepository> implements TipoContatoService {

}
