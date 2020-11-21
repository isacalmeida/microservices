package br.edu.unoesc.sistemautils.arquitetura.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractEntity;

public interface ICrudRepository<E extends AbstractEntity, ID extends Number> extends JpaRepository<E, ID> {

	Page<E> findByIsExcluido(Boolean isExcluido, Pageable pageable);
}
