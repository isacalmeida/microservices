package br.edu.unoesc.pessoaservice.persistence.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoaservice.common.model.Contato;
import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.pessoaservice.persistence.repository.ContatoRepository;
import br.edu.unoesc.pessoaservice.persistence.repository.PessoaRepository;
import br.edu.unoesc.pessoaservice.persistence.service.ContatoService;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractDetailCrudService;

@Service
public class ContatoServiceImpl extends AbstractDetailCrudService<Pessoa, Contato, PessoaRepository, ContatoRepository> implements ContatoService {

}
