package br.edu.unoesc.sistemautils.arquitetura.business;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.unoesc.sistemautils.arquitetura.business.common.IDetailCrudService;
import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractDetailEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractMasterEntity;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.IDetailRepository;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.IMasterRepository;

public abstract class AbstractDetailCrudService<EM extends AbstractMasterEntity, ED extends AbstractDetailEntity<EM>, RM extends IMasterRepository<EM, Long>, RD extends IDetailRepository<EM, ED, Long>> implements IDetailCrudService<EM, ED> {

	@Autowired
	private RM masterRepository;

	@Autowired
	private RD detailRepository;

	@Override
	public Page<ED> getAllPaged(Long idParent, Pageable pageable) {
		ED detailEntity = getDetailEntityInstance();
		if(Objects.isNull(detailEntity)) {
			// TODO
		}
		EM masterEntity = masterRepository.getOne(idParent);
		detailEntity.setMasterEntity(masterEntity);
		detailEntity.setIsExcluido(Boolean.FALSE);
		Example<ED> detailEntityExample = Example.of(detailEntity);
		return detailRepository.findAll(detailEntityExample, pageable);
	}

	@Override
	public List<ED> getAll(Long idParent) {
		ED detailEntity = getDetailEntityInstance();
		if(Objects.isNull(detailEntity)) {
			// TODO
		}
		EM masterEntity = masterRepository.getOne(idParent);
		detailEntity.setMasterEntity(masterEntity);
		detailEntity.setIsExcluido(Boolean.FALSE);
		Example<ED> detailEntityExample = Example.of(detailEntity);
		return detailRepository.findAll(detailEntityExample);
	}

	@Override
	public Optional<ED> getOne(Long idParent, Long id) {
		Optional<ED> detailEntityOptional = detailRepository.findById(id);
		if(detailEntityOptional.isEmpty()) {
			return detailEntityOptional;
		}
		ED detailEntity = detailEntityOptional.get();
		EM masterEntity = masterRepository.getOne(idParent);
		if(!detailEntity.getMasterEntity().getId().equals(masterEntity.getId())) {
			return Optional.empty();
		}
		return detailEntityOptional;
	}

	@Override
	public ED create(Long idParent, ED detailEntity) {
		EM masterEntity = masterRepository.getOne(idParent);
		detailEntity.setMasterEntity(masterEntity);
		detailEntity.setDataCriacao(Calendar.getInstance().getTime());
		popularPersistable(detailEntity);
		return detailRepository.save(detailEntity);
	}

	@Override
	public ED update(Long idParent, ED detailEntity) {
		EM masterEntity = masterRepository.getOne(idParent);
		if(Objects.isNull(masterEntity)) {
			// TODO
		}
		detailEntity.setMasterEntity(masterEntity);
		detailEntity.setDataAlteracao(Calendar.getInstance().getTime());
		return detailRepository.save(detailEntity);
	}

	@Override
	public void delete(Long idParent, Long id) {
		EM masterEntity = masterRepository.getOne(idParent);
		ED detailEntity = detailRepository.getOne(id);
		if(!masterEntity.getId().equals(detailEntity.getMasterEntity().getId())) {
			// TODO
		}
		detailEntity.setIsExcluido(Boolean.TRUE);
		update(idParent, detailEntity);
	}

	@SuppressWarnings("unchecked")
	protected ED getDetailEntityInstance() {
		Type[] typeArguments = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
		for (Type type : typeArguments) {
			if ((type instanceof Class) && (AbstractDetailEntity.class.isAssignableFrom((Class<?>) type))) {
				try {
					return ((Class<ED>) type).getDeclaredConstructor().newInstance();
				}
				catch (Exception exception) {
				}
			}
		}
		return null;
	}

	private void popularPersistable(ED detailEntity) {
		if(Objects.isNull(detailEntity.getIsAtivo())) {
			detailEntity.setIsAtivo(Boolean.TRUE);
		}
		if(Objects.isNull(detailEntity.getIsCancelado())) {
			detailEntity.setIsCancelado(Boolean.FALSE);
		}
		if(Objects.isNull(detailEntity.getIsExcluido())) {
			detailEntity.setIsExcluido(Boolean.FALSE);
		}
	}
}
