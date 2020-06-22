package br.edu.unoesc.sistemautils.arquitetura.business;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import br.edu.unoesc.sistemautils.arquitetura.common.IIdentityEntity;

public interface IIdentityService<E extends IIdentityEntity<ID>, ID extends Number> {

	Page<E> getAllPaged(Integer page, Integer size);

    List<E> getAll();

    Optional<E> getOne(Long id);

    E create(E entity);

    E update(E entity);
}
