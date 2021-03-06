package br.edu.unoesc.sistemautils.arquitetura.business.common;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.unoesc.sistemautils.arquitetura.common.model.IIdentityEntity;

public interface IIdentityService<E extends IIdentityEntity<ID>, ID extends Number> {

	Page<E> getAllPaged(Pageable pageable);

    List<E> getAll();

    Optional<E> getOne(ID id);

    E create(E entity);

    E update(E entity);
}
