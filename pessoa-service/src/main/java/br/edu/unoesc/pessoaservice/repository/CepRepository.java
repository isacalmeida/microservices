package br.edu.unoesc.pessoaservice.repository;

import br.edu.unoesc.pessoaservice.model.Cep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {

    List<Cep> findAllByCidade_Estado_IdAndCidade_Id(Long idEstado, Long idCidade);

    List<Cep> findAllByCepStartingWithOrderByCep(String cep);
}
