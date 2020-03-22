package br.edu.unoesc.pessoaservice.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.common.model.Cep;
import br.edu.unoesc.sistemautils.arquitetura.persistence.IRepository;

@Repository
public interface CepRepository extends IRepository<Cep, Long> {

    List<Cep> findAllByCidade_Estado_IdEstadoAndCidade_IdCidade(Long idEstado, Long idCidade);

    List<Cep> findAllByCepStartingWithOrderByCep(String cep);
}
