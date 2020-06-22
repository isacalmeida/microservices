package br.edu.unoesc.sistemautils.arquitetura.business;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDetailEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.AbstractMasterEntity;

public interface IDetailCrudService<EM extends AbstractMasterEntity, ED extends AbstractDetailEntity<EM>> {

	Page<ED> getAllPaged(Long idParent, Class<ED> classDetailEntity, Integer page, Integer size);

	List<ED> getAll(Long idParent, Class<ED> classDetailEntity);

    Optional<ED> getOne(Long idParent, Long id);

    ED create(Long idParent, ED detailEntity);

    ED update(Long idParent, ED detailEntity);

    void delete(Long idParent, Long id);
}
