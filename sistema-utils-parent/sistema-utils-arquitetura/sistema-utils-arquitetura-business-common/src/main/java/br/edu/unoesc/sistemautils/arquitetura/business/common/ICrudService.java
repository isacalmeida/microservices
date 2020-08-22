package br.edu.unoesc.sistemautils.arquitetura.business.common;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractEntity;

public interface ICrudService<E extends AbstractEntity> {

	Page<E> getAllPaged(Integer page, Integer size);

    List<E> getAll();

    Optional<E> getOne(Long id);

    E create(E entity);

    E update(E entity);

    void delete(Long id);
}
