package br.edu.unoesc.pessoaservice.persistence.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.pessoaservice.common.model.TipoDocumentoPessoa;
import br.edu.unoesc.pessoaservice.persistence.repository.PessoaRepository;
import br.edu.unoesc.pessoaservice.persistence.repository.TipoDocumentoPessoaRepository;
import br.edu.unoesc.pessoaservice.persistence.service.TipoDocumentoPessoaService;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractDetailCrudService;

@Service
public class TipoDocumentoPessoaServiceImpl extends AbstractDetailCrudService<Pessoa, TipoDocumentoPessoa, PessoaRepository, TipoDocumentoPessoaRepository> implements TipoDocumentoPessoaService {

}
