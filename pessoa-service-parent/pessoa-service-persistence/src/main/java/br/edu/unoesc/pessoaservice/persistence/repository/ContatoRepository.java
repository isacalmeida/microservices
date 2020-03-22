package br.edu.unoesc.pessoaservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.common.model.Contato;
import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.sistemautils.arquitetura.persistence.IDetailRepository;

@Repository
public interface ContatoRepository extends IDetailRepository<Pessoa, Contato, Long> {

}
