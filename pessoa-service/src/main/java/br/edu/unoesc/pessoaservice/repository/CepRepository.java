package br.edu.unoesc.pessoaservice.repository;

import br.edu.unoesc.pessoaservice.model.Cep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CepRepository extends JpaRepository<Cep, Long> {
}
