package br.edu.unoesc.pessoaservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findAllByEstado_Id(Long idEstado);

    List<Cidade> findAllByEstado_SiglaAndDescricao(String sigla, String descricao);
}
