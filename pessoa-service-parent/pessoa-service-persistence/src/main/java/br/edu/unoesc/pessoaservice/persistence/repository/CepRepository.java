package br.edu.unoesc.pessoaservice.persistence.repository.cep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.common.model.cep.Cep;

@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {

    List<Cep> findAllByCidade_Estado_IdAndCidade_Id(Long idEstado, Long idCidade);

    List<Cep> findAllByCepStartingWithOrderByCep(String cep);
}
