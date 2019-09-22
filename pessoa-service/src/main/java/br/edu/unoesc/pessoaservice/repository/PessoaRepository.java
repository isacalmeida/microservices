package br.edu.unoesc.pessoaservice.repository;

import br.edu.unoesc.pessoaservice.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
