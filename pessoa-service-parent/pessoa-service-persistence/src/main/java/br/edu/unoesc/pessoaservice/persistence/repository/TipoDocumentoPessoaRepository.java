package br.edu.unoesc.pessoaservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.pessoaservice.common.model.TipoDocumentoPessoa;
import br.edu.unoesc.sistemautils.arquitetura.persistence.IDetailRepository;

@Repository
public interface TipoDocumentoPessoaRepository extends IDetailRepository<Pessoa, TipoDocumentoPessoa, Long> {

}
