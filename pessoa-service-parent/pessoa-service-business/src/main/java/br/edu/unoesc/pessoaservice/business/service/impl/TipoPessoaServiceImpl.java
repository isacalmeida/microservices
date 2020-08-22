package br.edu.unoesc.pessoaservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoaservice.business.common.service.TipoPessoaService;
import br.edu.unoesc.pessoaservice.common.model.TipoPessoa;
import br.edu.unoesc.pessoaservice.persistence.repository.TipoPessoaRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;

@Service
public class TipoPessoaServiceImpl extends AbstractIdentityService<TipoPessoa, Long, TipoPessoaRepository> implements TipoPessoaService {

}
