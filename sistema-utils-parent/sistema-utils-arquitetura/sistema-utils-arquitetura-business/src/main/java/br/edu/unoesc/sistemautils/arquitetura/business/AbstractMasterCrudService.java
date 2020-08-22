package br.edu.unoesc.sistemautils.arquitetura.business;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractMasterEntity;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.IMasterRepository;

public abstract class AbstractMasterCrudService<EM extends AbstractMasterEntity, R extends IMasterRepository<EM, Long>> implements IMasterCrudService<EM> {

	@Autowired
	private R repository;

	@Override
	public Page<EM> getAllPaged(Integer page, Integer size) {
		return repository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<EM> getAll() {
		return repository.findAll();
	}

	@Override
	public Optional<EM> getOne(Long id) {
		return repository.findById(id);
	}

	@Override
	public EM create(EM entity) {
		entity.setDataCriacao(Calendar.getInstance().getTime());
		return repository.save(entity);
	}

	@Override
	public EM update(EM entity) {
		entity.setDataAlteracao(Calendar.getInstance().getTime());
		return repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		EM entity = getOne(id).get();
		entity.setIsExcluido(Boolean.TRUE);
		update(entity);
	}
}
