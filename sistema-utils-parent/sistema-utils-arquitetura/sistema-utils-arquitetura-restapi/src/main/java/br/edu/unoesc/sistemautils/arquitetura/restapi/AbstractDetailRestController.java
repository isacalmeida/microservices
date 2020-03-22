package br.edu.unoesc.sistemautils.arquitetura.restapi;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.unoesc.sistemautils.arquitetura.business.IDetailCrudService;
import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDTO;
import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDetailEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.AbstractMasterEntity;

public abstract class AbstractDetailRestController<EM extends AbstractMasterEntity, ED extends AbstractDetailEntity<EM>, DTO extends AbstractDTO<DTO>, S extends IDetailCrudService<EM, ED>, C extends IDetailDTOConverter<EM, ED, DTO>> implements IDetailCrudController<EM, ED, DTO> {

	@Autowired
	private S service;
	
	@Autowired
	private C converter;

	@Override
	public ResponseEntity<List<DTO>> getAll(Long idParent, Class<ED> detailEntityClass) {
		List<DTO> all = service.getAll(idParent, detailEntityClass).stream()
				.map(detailEntity -> converter.convertToDTO(detailEntity))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(all);
	}

	@Override
	public Page<DTO> getAllPaged(Long idParent, Integer page, Integer size) {
		Page<ED> allPaged = service.getAllPaged(idParent, page, size);
		return new PageImpl<DTO>(converter.convertToDTO(allPaged.getContent()), Pageable.unpaged(), allPaged.getTotalElements());
	}

	@Override
	public ResponseEntity<DTO> getOne(Long idParent, Long id) {
		return service.getOne(idParent, id)
				.map(detailEntity -> ResponseEntity.ok().body(converter.convertToDTO(detailEntity)))
				.orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<DTO> create(Long idParent, DTO dto) {
		if(Objects.isNull(dto)) {
            return ResponseEntity.noContent().build();
        }
		ED detailEntityCreated = service.create(idParent, converter.convertToEntity(dto));
		DTO DTOCreated = converter.convertToDTO(detailEntityCreated);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(DTOCreated.getId()).toUri();

		return ResponseEntity.created(location).body(DTOCreated);
	}

	@Override
	public ResponseEntity<DTO> update(Long idParent, Long id, DTO dto) {
		Optional<ED> detailEntity = service.getOne(idParent, id);
        if(detailEntity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
		if(Objects.isNull(dto)) {
		    return ResponseEntity.noContent().build();
		}
		dto.setId(detailEntity.get().getId());
		ED detailEntityUpdated = service.update(idParent, converter.convertToEntity(dto));
		DTO DTOCreated = converter.convertToDTO(detailEntityUpdated);
		
		return ResponseEntity.ok(DTOCreated);
	}

	@Override
	public ResponseEntity<Long> delete(Long idParent, Long id) {
		return service.getOne(idParent, id)
                .map(detailEntity -> {
                	service.delete(idParent, id);
                    return ResponseEntity.ok().body(id);
                })
                .orElse(ResponseEntity.notFound().build());
	}
}
