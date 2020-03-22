package br.edu.unoesc.sistemautils.arquitetura.restapi;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDTO;
import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDetailEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.AbstractMasterEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.RestapiConstants;

public interface IDetailCrudController<EM extends AbstractMasterEntity, ED extends AbstractDetailEntity<EM>, DTO extends AbstractDTO<DTO>> {

	@GetMapping(RestapiConstants.ALL)
	ResponseEntity<List<DTO>> getAll(@PathVariable Long idParent, Class<ED> detailClassEntity);

	@GetMapping
	@ResponseBody
	Page<DTO> getAllPaged(@PathVariable Long idParent,
			@RequestParam(required = false, defaultValue = "0") Integer page,
			@RequestParam(required = false, defaultValue = "10") Integer size);

	@GetMapping(RestapiConstants.ID)
	ResponseEntity<DTO> getOne(@PathVariable Long idParent, @PathVariable Long id);

	@PostMapping
	ResponseEntity<DTO> create(@PathVariable Long idParent, @RequestBody DTO dto);

	@PutMapping(RestapiConstants.ID)
	ResponseEntity<DTO> update(@PathVariable Long idParent, @PathVariable Long id, @RequestBody DTO dto);

	@DeleteMapping(RestapiConstants.ID)
	ResponseEntity<Long> delete(@PathVariable Long idParent, @PathVariable Long id);
}
