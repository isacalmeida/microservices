package br.edu.unoesc.pessoaservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoaservice.business.common.service.GeneroPessoaService;
import br.edu.unoesc.pessoaservice.common.model.GeneroPessoa;
import br.edu.unoesc.pessoaservice.persistence.repository.GeneroPessoaRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;

@Service
public class GeneroPessoaServiceImpl extends AbstractIdentityService<GeneroPessoa, Long, GeneroPessoaRepository> implements GeneroPessoaService {

}
