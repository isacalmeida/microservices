package br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.unoesc.sistemautils.arquitetura.business.common.IDetailCrudService;
import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractDetailEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractMasterEntity;
import br.edu.unoesc.sistemautils.arquitetura.restapi.common.controller.IDetailCrudController;
import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.AbstractDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IDetailDTOConverter;

public abstract class AbstractDetailRestController<EM extends AbstractMasterEntity, ED extends AbstractDetailEntity<EM>, DTO extends AbstractDTO<DTO>, S extends IDetailCrudService<EM, ED>, C extends IDetailDTOConverter<EM, ED, DTO>> implements IDetailCrudController<EM, ED, DTO> {

	@Autowired
	private S service;
	
	@Autowired
	private C converter;

	@Override
	public ResponseEntity<List<DTO>> getAll(Long idParent) {
		List<DTO> all = getService().getAll(idParent).stream()
				.map(detailEntity -> getConverter().convertToDTO(detailEntity))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(all);
	}

	@Override
	public Page<DTO> getAllPaged(Long idParent, Pageable pageable) {
		Page<ED> allPaged = getService().getAllPaged(idParent, pageable);
		return allPaged.map(getConverter()::convertToDTO);
	}

	@Override
	public ResponseEntity<DTO> getOne(Long idParent, Long id) {
		return getService().getOne(idParent, id)
				.map(detailEntity -> ResponseEntity.ok().body(getConverter().convertToDTO(detailEntity)))
				.orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<DTO> create(Long idParent, DTO dto) {
		if(Objects.isNull(dto)) {
            return ResponseEntity.noContent().build();
        }
		ED detailEntityCreated = getService().create(idParent, getConverter().convertToEntity(dto));
		DTO DTOCreated = getConverter().convertToDTO(detailEntityCreated);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(DTOCreated.getId()).toUri();

		return ResponseEntity.created(location).body(DTOCreated);
	}

	@Override
	public ResponseEntity<DTO> update(Long idParent, Long id, DTO dto) {
		Optional<ED> detailEntity = getService().getOne(idParent, id);
        if(detailEntity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
		if(Objects.isNull(dto)) {
		    return ResponseEntity.noContent().build();
		}
		dto.setId(detailEntity.get().getId());
		ED detailEntityUpdated = getService().update(idParent, getConverter().convertToEntity(dto));
		DTO DTOCreated = getConverter().convertToDTO(detailEntityUpdated);
		
		return ResponseEntity.ok(DTOCreated);
	}

	@Override
	public ResponseEntity<Long> delete(Long idParent, Long id) {
		return getService().getOne(idParent, id)
                .map(detailEntity -> {
                	getService().delete(idParent, id);
                    return ResponseEntity.ok().body(id);
                })
                .orElse(ResponseEntity.notFound().build());
	}

	protected S getService() {
		return service;
	}

	protected C getConverter() {
		return converter;
	}
}
