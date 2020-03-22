package br.edu.unoesc.pessoaservice.persistence.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoaservice.common.model.PessoaFisica;
import br.edu.unoesc.pessoaservice.persistence.repository.PessoaFisicaRepository;
import br.edu.unoesc.pessoaservice.persistence.service.PessoaFisicaService;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractMasterCrudService;

@Service
public class PessoaFisicaServiceImpl extends AbstractMasterCrudService<PessoaFisica, PessoaFisicaRepository> implements PessoaFisicaService {

}
