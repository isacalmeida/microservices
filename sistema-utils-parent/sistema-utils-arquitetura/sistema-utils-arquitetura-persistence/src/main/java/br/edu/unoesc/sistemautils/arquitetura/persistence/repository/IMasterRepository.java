package br.edu.unoesc.sistemautils.arquitetura.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractMasterEntity;

public interface IMasterRepository<EM extends AbstractMasterEntity, ID extends Number> extends JpaRepository<EM, ID> {

	Page<EM> findByIsExcluido(Boolean isExcluido, Pageable pageable);
}
