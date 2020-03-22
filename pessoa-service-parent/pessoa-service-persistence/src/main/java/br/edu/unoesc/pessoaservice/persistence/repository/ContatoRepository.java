package br.edu.unoesc.pessoaservice.persistence.repository.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.common.model.pessoa.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
