package br.edu.unoesc.pessoaservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.common.model.PessoaJuridica;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.IMasterRepository;

@Repository
public interface PessoaJuridicaRepository extends IMasterRepository<PessoaJuridica, Long> {
}
