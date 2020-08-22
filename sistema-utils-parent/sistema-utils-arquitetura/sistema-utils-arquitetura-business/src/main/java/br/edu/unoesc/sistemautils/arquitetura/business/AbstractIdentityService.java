package br.edu.unoesc.sistemautils.arquitetura.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.edu.unoesc.sistemautils.arquitetura.common.IIdentityEntity;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.IIdentityRepository;

public abstract class AbstractIdentityService<E extends IIdentityEntity<ID>, ID extends Number, R extends IIdentityRepository<E, ID>> implements IIdentityService<E, ID> {

	@Autowired
	private R repository;

	@Override
	public Page<E> getAllPaged(Integer page, Integer size) {
		return getRepository().findAll(PageRequest.of(page, size));
	}

	@Override
	public List<E> getAll() {
		return getRepository().findAll();
	}

	@Override
	public Optional<E> getOne(ID id) {
		return getRepository().findById(id);
	}

	@Override
	public E create(E entity) {
		return getRepository().save(entity);
	}

	@Override
	public E update(E entity) {
		return getRepository().save(entity);
	}

	public R getRepository() {
		return repository;
	}
}
