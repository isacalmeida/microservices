package br.edu.unoesc.pessoaservice.persistence.repository.cep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.common.model.cep.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
