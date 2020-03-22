package br.edu.unoesc.pessoaservice.persistence.repository.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.common.model.pessoa.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
