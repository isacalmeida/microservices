package br.edu.unoesc.pessoaservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoaservice.business.common.service.TipoEnderecoService;
import br.edu.unoesc.pessoaservice.common.model.TipoEndereco;
import br.edu.unoesc.pessoaservice.persistence.repository.TipoEnderecoRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;

@Service
public class TipoEnderecoServiceImpl extends AbstractIdentityService<TipoEndereco, Long, TipoEnderecoRepository> implements TipoEnderecoService {

}
