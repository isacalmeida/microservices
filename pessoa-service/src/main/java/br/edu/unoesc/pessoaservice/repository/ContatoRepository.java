package br.edu.unoesc.pessoaservice.repository;

import br.edu.unoesc.pessoaservice.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
