package br.edu.unoesc.sistemautils.arquitetura.restapi.common.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractDetailEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractMasterEntity;
import br.edu.unoesc.sistemautils.arquitetura.restapi.common.constants.RestapiConstants;
import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.AbstractDTO;

public interface IDetailCrudController<EM extends AbstractMasterEntity, ED extends AbstractDetailEntity<EM>, DTO extends AbstractDTO<DTO>> {

	@GetMapping(RestapiConstants.ALL)
	ResponseEntity<List<DTO>> getAll(@PathVariable Long idParent);

	@GetMapping
	Page<DTO> getAllPaged(@PathVariable Long idParent, Pageable pageable);

	@GetMapping(RestapiConstants.ID)
	ResponseEntity<DTO> getOne(@PathVariable Long idParent, @PathVariable Long id);

	@PostMapping
	ResponseEntity<DTO> create(@PathVariable Long idParent, @RequestBody DTO dto);

	@PutMapping(RestapiConstants.ID)
	ResponseEntity<DTO> update(@PathVariable Long idParent, @PathVariable Long id, @RequestBody DTO dto);

	@DeleteMapping(RestapiConstants.ID)
	ResponseEntity<Long> delete(@PathVariable Long idParent, @PathVariable Long id);
}
