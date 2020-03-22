package br.edu.unoesc.pessoaservice.web.api.v1.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.unoesc.pessoaservice.api.dto.pessoa.PessoaDTO;
import br.edu.unoesc.pessoaservice.common.model.pessoa.Pessoa;
import br.edu.unoesc.pessoaservice.persistence.service.pessoa.PessoaService;
import br.edu.unoesc.pessoaservice.web.api.v1.converter.PessoaDTOConverter;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaRestController {

	@Autowired
	private PessoaService pessoaService;

	private PessoaDTOConverter pessoaDTOConverter;

	@GetMapping
	public List<PessoaDTO> getAll() {
		
		return pessoaService.getAll().stream().map(pessoa -> pessoaDTOConverter.convertToDTO(pessoa))
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PessoaDTO> getOne(@PathVariable Long id) {
		
		return pessoaService.getOne(id)
				.map(pessoa -> ResponseEntity.ok().body(pessoaDTOConverter.convertToDTO(pessoa)))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO){
		
		if(pessoaDTO == null) {
            return ResponseEntity.noContent().build();
        }
		Pessoa pessoaCreated = pessoaService.create(pessoaDTOConverter.convertToEntity(pessoaDTO));
		PessoaDTO pessoaDTOCreated = pessoaDTOConverter.convertToDTO(pessoaCreated);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(pessoaDTOCreated.getId()).toUri();

		return ResponseEntity.created(location).body(pessoaDTOCreated);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO){
        
		Optional<Pessoa> pessoa = pessoaService.getOne(id);
        if(pessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
		if(pessoaDTO == null) {
		    return ResponseEntity.noContent().build();
		}
		
		pessoaDTO.setId(pessoa.get().getId());
		Pessoa pessoaUpdated = pessoaService.update(pessoaDTOConverter.convertToEntity(pessoaDTO));
		PessoaDTO pessoaDTOCreated = pessoaDTOConverter.convertToDTO(pessoaUpdated);
		
		return ResponseEntity.ok(pessoaDTOCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        return pessoaService.getOne(id)
                .map(cep -> {
                	pessoaService.delete(id);
                    return ResponseEntity.ok().body(id);
                }).orElse(ResponseEntity.notFound().build());
    }
}
