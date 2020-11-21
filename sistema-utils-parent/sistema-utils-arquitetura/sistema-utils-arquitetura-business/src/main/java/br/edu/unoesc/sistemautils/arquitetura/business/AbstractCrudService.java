package br.edu.unoesc.sistemautils.arquitetura.business;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.unoesc.sistemautils.arquitetura.business.common.ICrudService;
import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractEntity;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.ICrudRepository;

public abstract class AbstractCrudService<E extends AbstractEntity, R extends ICrudRepository<E, Long>> implements ICrudService<E> {

	@Autowired
	private R repository;

	@Override
	public Page<E> getAllPaged(Pageable pageable) {
		return getRepository().findByIsExcluido(Boolean.FALSE, pageable);
	}

	@Override
	public List<E> getAll() {
		return getRepository().findAll();
	}

	@Override
	public Optional<E> getOne(Long id) {
		return getRepository().findById(id);
	}

	@Override
	public E create(E entity) {
		entity.setDataCriacao(Calendar.getInstance().getTime());
		entity.setIsAtivo(Boolean.TRUE);
		entity.setIsCancelado(Boolean.FALSE);
		entity.setIsExcluido(Boolean.FALSE);
		
		return getRepository().save(entity);
	}

	@Override
	public E update(E entity) {
		entity.setDataAlteracao(Calendar.getInstance().getTime());
		return getRepository().save(entity);
	}

	@Override
	public void delete(Long id) {
		E entity = getOne(id).get();
		entity.setIsExcluido(Boolean.TRUE);
		update(entity);
	}

	public R getRepository() {
		return repository;
	}
}
