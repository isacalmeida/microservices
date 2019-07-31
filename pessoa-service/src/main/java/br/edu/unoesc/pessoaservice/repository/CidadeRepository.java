package br.edu.unoesc.pessoaservice.repository;

import br.edu.unoesc.pessoaservice.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findAllByEstado_Id(Long idEstado);
}
