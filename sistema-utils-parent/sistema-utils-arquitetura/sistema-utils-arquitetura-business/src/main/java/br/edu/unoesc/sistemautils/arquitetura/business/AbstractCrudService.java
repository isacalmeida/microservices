package br.edu.unoesc.sistemautils.arquitetura.business;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractEntity;
import br.edu.unoesc.sistemautils.arquitetura.persistence.IRepository;

public abstract class AbstractCrudService<E extends AbstractEntity, R extends IRepository<E, Long>> implements ICrudService<E> {

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
		entity.setDataCriacao(Calendar.getInstance().getTime());
		return repository.save(entity);
	}

	@Override
	public E update(E entity) {
		entity.setDataAlteracao(Calendar.getInstance().getTime());
		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		E entity = getOne(id).get();
		entity.setIsExcluido(Boolean.TRUE);
		update(entity);
	}
}
