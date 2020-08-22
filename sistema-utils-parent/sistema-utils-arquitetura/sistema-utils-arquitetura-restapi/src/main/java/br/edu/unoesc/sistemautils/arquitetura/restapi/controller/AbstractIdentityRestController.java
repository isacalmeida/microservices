package br.edu.unoesc.sistemautils.arquitetura.restapi.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import br.edu.unoesc.sistemautils.arquitetura.business.IIdentityService;
import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDTO;
import br.edu.unoesc.sistemautils.arquitetura.common.IIdentityEntity;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IIdentityDTOConverter;

public abstract class AbstractIdentityRestController<E extends IIdentityEntity<ID>, ID extends Number, DTO extends AbstractDTO<DTO>, S extends IIdentityService<E, ID>, C extends IIdentityDTOConverter<E, ID, DTO>> implements IIdentityRestController<ID, DTO> {

	@Autowired
	private S service;
	
	@Autowired
	private C converter;

	@Autowired
	private Environment environment;

	@Override
	public ResponseEntity<List<DTO>> getAll() {
		List<DTO> all = service.getAll().stream()
				.map(masterEntity -> converter.convertToDTO(masterEntity))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(all);
	}
	
	@Override
	public Page<DTO> getAllPaged(Integer page, Integer size) {
		Page<E> allPaged = service.getAllPaged(page, size);
		return new PageImpl<DTO>(converter.convertToDTO(allPaged.getContent()), Pageable.unpaged(), allPaged.getTotalElements());
	}

	@Override
	public ResponseEntity<DTO> getOne(ID id) {
		return service.getOne(id)
			.map(masterEntity -> ResponseEntity.ok().body(converter.convertToDTO(masterEntity)))
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
		Link read = linkTo(getClass()).slash(1L).withRel("read").withType("GET");
		Link environmentPort = linkTo(methodOn(getClass()).getEnvironmentPort()).withRel("getEnvironmentPort").withType("GET");

		List<Link> links = new ArrayList<Link>();
		links.add(allPaged);
		links.add(read);
		links.add(environmentPort);
		return new HttpEntity<List<Link>>(links);
	}
}
