package br.edu.unoesc.sistemautils.arquitetura.restapi.common.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractMasterEntity;
import br.edu.unoesc.sistemautils.arquitetura.restapi.common.constants.RestapiConstants;
import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.AbstractDTO;

public interface IMasterCrudController<EM extends AbstractMasterEntity, DTO extends AbstractDTO<DTO>> {

	@GetMapping(RestapiConstants.ALL)
	ResponseEntity<List<DTO>> getAll();

	@GetMapping
	Page<DTO> getAllPaged(Pageable pageable);

	@GetMapping(RestapiConstants.ID)
	ResponseEntity<DTO> getOne(@PathVariable Long id);

	@PostMapping
	ResponseEntity<DTO> create(@RequestBody DTO dto);

	@PutMapping(RestapiConstants.ID)
	ResponseEntity<DTO> update(@PathVariable Long id, @RequestBody DTO dto);

	@DeleteMapping(RestapiConstants.ID)
	ResponseEntity<Long> delete(@PathVariable Long id);

	@GetMapping(RestapiConstants.ENVIRONMENT_PORT)
	ResponseEntity<Integer> getEnvironmentPort();

	@RequestMapping(method = RequestMethod.OPTIONS)
	HttpEntity<List<Link>> getResourceList();
}
