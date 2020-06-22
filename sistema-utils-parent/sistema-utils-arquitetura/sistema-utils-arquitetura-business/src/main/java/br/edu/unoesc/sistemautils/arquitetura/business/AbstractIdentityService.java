package br.edu.unoesc.sistemautils.arquitetura.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.edu.unoesc.sistemautils.arquitetura.common.IIdentityEntity;
import br.edu.unoesc.sistemautils.arquitetura.persistence.IRepository;

public abstract class AbstractIdentityService<E extends IIdentityEntity<ID>, ID extends Number, R extends IRepository<E, Long>> implements IIdentityService<E, ID> {

	@Autowired
	private R repository;

	@Override
	public Page<E> getAllPaged(Integer page, Integer size) {
		return repository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<E> getAll() {
		return repository.findAll();
	}

	@Override
	public Optional<E> getOne(Long id) {
		return repository.findById(id);
	}

	@Override
	public E create(E entity) {
		return null;
	}

	@Override
	public E update(E entity) {
		return null;
	}
}
