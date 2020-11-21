package br.edu.unoesc.sistemautils.arquitetura.business.common;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractDetailEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractMasterEntity;

public interface IDetailCrudService<EM extends AbstractMasterEntity, ED extends AbstractDetailEntity<EM>> {

	Page<ED> getAllPaged(Long idParent, Pageable pageable);

	List<ED> getAll(Long idParent);

    Optional<ED> getOne(Long idParent, Long id);

    ED create(Long idParent, ED detailEntity);

    ED update(Long idParent, ED detailEntity);

    void delete(Long idParent, Long id);
}
