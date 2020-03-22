package br.edu.unoesc.pessoaservice.persistence.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoaservice.common.model.Endereco;
import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.pessoaservice.persistence.repository.EnderecoRepository;
import br.edu.unoesc.pessoaservice.persistence.repository.PessoaRepository;
import br.edu.unoesc.pessoaservice.persistence.service.EnderecoService;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractDetailCrudService;

@Service
public class EnderecoServiceImpl extends AbstractDetailCrudService<Pessoa, Endereco, PessoaRepository, EnderecoRepository> implements EnderecoService {

}
