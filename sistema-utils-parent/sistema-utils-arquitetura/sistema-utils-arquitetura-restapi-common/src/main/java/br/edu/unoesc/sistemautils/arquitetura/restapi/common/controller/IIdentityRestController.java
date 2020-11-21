package br.edu.unoesc.sistemautils.arquitetura.restapi.common.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.constants.RestapiConstants;
import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.AbstractDTO;

public interface IIdentityRestController<ID extends Number, DTO extends AbstractDTO<DTO>> {

	@GetMapping(RestapiConstants.ALL)
	ResponseEntity<List<DTO>> getAll();

	@GetMapping
	Page<DTO> getAllPaged(Pageable pageable);

	@GetMapping(RestapiConstants.ID)
	ResponseEntity<DTO> getOne(@PathVariable ID id);

	@GetMapping(RestapiConstants.ENVIRONMENT_PORT)
	ResponseEntity<Integer> getEnvironmentPort();

	@RequestMapping(method = RequestMethod.OPTIONS)
	HttpEntity<List<Link>> getResourceList();
}
