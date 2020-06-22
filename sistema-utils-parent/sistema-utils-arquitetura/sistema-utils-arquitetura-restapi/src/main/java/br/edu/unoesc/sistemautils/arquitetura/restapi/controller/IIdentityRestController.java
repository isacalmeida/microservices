package br.edu.unoesc.sistemautils.arquitetura.restapi.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDTO;
import br.edu.unoesc.sistemautils.arquitetura.common.RestapiConstants;

public interface IIdentityRestController<DTO extends AbstractDTO<DTO>> {

	@GetMapping(RestapiConstants.ALL)
	ResponseEntity<List<DTO>> getAll();

	@GetMapping
	@ResponseBody
	Page<DTO> getAllPaged(@RequestParam(required = false, defaultValue = "0") Integer page, 
			@RequestParam(required = false, defaultValue = "10") Integer size);

	@GetMapping(RestapiConstants.ID)
	ResponseEntity<DTO> getOne(@PathVariable Long id);

	@GetMapping(RestapiConstants.ENVIRONMENT_PORT)
	ResponseEntity<Integer> getEnvironmentPort();

	@RequestMapping(method = RequestMethod.OPTIONS)
	HttpEntity<List<Link>> getResourceList();
}
