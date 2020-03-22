package br.edu.unoesc.pessoaservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.pessoaservice.common.model.Estado;
import br.edu.unoesc.sistemautils.arquitetura.persistence.IRepository;

@Repository
public interface EstadoRepository extends IRepository<Estado, Long> {

}
