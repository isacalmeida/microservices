package br.edu.unoesc.pessoaservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.common.model.PessoaFisica;
import br.edu.unoesc.sistemautils.arquitetura.persistence.IMasterRepository;

@Repository
public interface PessoaFisicaRepository extends IMasterRepository<PessoaFisica, Long> {

}
