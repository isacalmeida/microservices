package br.edu.unoesc.pessoaservice.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.common.model.Cep;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.ICrudRepository;

@Repository
public interface CepRepository extends ICrudRepository<Cep, Long> {

    List<Cep> findAllByCidade_Estado_IdEstadoAndCidade_IdCidade(Long idEstado, Long idCidade);

    List<Cep> findAllByCepAndIsExcluidoStartingWithOrderByCep(String cep, Boolean isExcluido);

    Cep findByCepAndIsExcluido(String cep, Boolean isExcluido);
}
