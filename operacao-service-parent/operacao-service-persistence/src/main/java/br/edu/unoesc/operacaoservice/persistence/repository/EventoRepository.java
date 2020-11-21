package br.edu.unoesc.operacaoservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.operacaoservice.common.model.Evento;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.ICrudRepository;

@Repository
public interface EventoRepository extends ICrudRepository<Evento, Long> {
}
