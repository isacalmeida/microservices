package br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.unoesc.sistemautils.arquitetura.business.common.ICrudService;
import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractEntity;
import br.edu.unoesc.sistemautils.arquitetura.restapi.common.controller.ICrudRestController;
import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.AbstractDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IDTOConverter;

public abstract class AbstractRestController<E extends AbstractEntity, DTO extends AbstractDTO<DTO>, S extends ICrudService<E>, C extends IDTOConverter<E, DTO>> implements ICrudRestController<DTO> {

	@Autowired
	private S service;
	
	@Autowired
	private C converter;
	
	@Autowired
	private Environment environment;

	@Override
	public ResponseEntity<List<DTO>> getAll() {
		List<DTO> all = getService().getAll().stream()
				.map(entity -> getConverter().convertToDTO(entity))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(all);
	}
	
	@Override
	public Page<DTO> getAllPaged(Pageable pageable) {
		Page<E> allPaged = getService().getAllPaged(pageable);
		return allPaged.map(getConverter()::convertToDTO);
	}

	@Override
	public ResponseEntity<DTO> getOne(Long id) {
		return getService().getOne(id)
			.filter(entity -> Boolean.FALSE.equals(entity.getIsExcluido()))
			.map(entity -> ResponseEntity.ok().body(getConverter().convertToDTO(entity)))
			.orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<DTO> create(DTO dto) {
		if(Objects.isNull(dto)) {
            return ResponseEntity.noContent().build();
        }
		E entityCreated = getService().create(getConverter().convertToEntity(dto));
		DTO DTOCreated = getConverter().convertToDTO(entityCreated);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(DTOCreated.getId()).toUri();

		return ResponseEntity.created(location).body(DTOCreated);
	}

	@Override
	public ResponseEntity<DTO> update(Long id, DTO dto) {
		Optional<E> entity = getService().getOne(id);
        if(entity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
		if(Objects.isNull(dto)) {
		    return ResponseEntity.noContent().build();
		}
		dto.setId(entity.get().getId());
		E entityUpdated = getService().update(getConverter().convertToEntity(dto));
		DTO DTOCreated = getConverter().convertToDTO(entityUpdated);
		
		return ResponseEntity.ok(DTOCreated);
	}

	@Override
	public ResponseEntity<Long> delete(Long id) {
		return getService().getOne(id)
                .map(entity -> {
                	getService().delete(id);
                    return ResponseEntity.ok().body(id);
                })
                .orElse(ResponseEntity.notFound().build());
	}

	@Override
    public ResponseEntity<Integer> getEnvironmentPort(){
        Integer environmentPort = Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")));
        if(Objects.isNull(environmentPort)) {
        	return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(environmentPort);
    }

	@Override
	public HttpEntity<List<Link>> getResourceList() {
		Link allPaged = linkTo(getClass()).withRel("getAllPaged").withType("GET");
		Link create = linkTo(getClass()).withRel("create").withType("POST");
		Link read = linkTo(getClass()).slash(1L).withRel("read").withType("GET");
		Link update = linkTo(getClass()).slash(1L).withRel("update").withType("PUT");
		Link delete = linkTo(getClass()).slash(1L).withRel("delete").withType("DELETE");
		Link environmentPort = linkTo(methodOn(getClass()).getEnvironmentPort()).withRel("getEnvironmentPort").withType("GET");

		List<Link> links = new ArrayList<Link>();
		links.add(allPaged);
		links.add(create);
		links.add(read);
		links.add(update);
		links.add(delete);
		links.add(environmentPort);
		return new HttpEntity<List<Link>>(links);
	}

	public S getService() {
		return service;
	}

	public C getConverter() {
		return converter;
	}
}
