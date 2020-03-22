package br.edu.unoesc.pessoaservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.common.model.Endereco;
import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.sistemautils.arquitetura.persistence.IDetailRepository;

@Repository
public interface EnderecoRepository extends IDetailRepository<Pessoa, Endereco, Long> {

}
