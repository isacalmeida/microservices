package br.edu.unoesc.sistemautils.arquitetura.business;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.unoesc.sistemautils.arquitetura.business.common.IMasterCrudService;
import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractMasterEntity;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.IMasterRepository;

public abstract class AbstractMasterCrudService<EM extends AbstractMasterEntity, R extends IMasterRepository<EM, Long>> implements IMasterCrudService<EM> {

	@Autowired
	private R repository;

	@Override
	public Page<EM> getAllPaged(Pageable pageable) {
		return repository.findByIsExcluido(Boolean.FALSE, pageable);
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
		popularPersistable(entity);
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

	private void popularPersistable(EM entity) {
		if(Objects.isNull(entity.getIsAtivo())) {
			entity.setIsAtivo(Boolean.TRUE);
		}
		if(Objects.isNull(entity.getIsCancelado())) {
			entity.setIsCancelado(Boolean.FALSE);
		}
		if(Objects.isNull(entity.getIsExcluido())) {
			entity.setIsExcluido(Boolean.FALSE);
		}
	}
}
