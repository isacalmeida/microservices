package br.edu.unoesc.acessoservice.web.controller;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

import br.edu.unoesc.acessoservice.common.model.Programa;
import br.edu.unoesc.acessoservice.persistence.service.ProgramaService;

@RestController
@RequestMapping("/programas")
public class ProgramaController {

    // == fields ==
    private Environment environment;
    private ProgramaService programaService;

    // == constructors ==
    @Autowired
    public ProgramaController(Environment environment, ProgramaService programaService) {
        this.environment = environment;
        this.programaService = programaService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Programa> listAll(){
        return programaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Programa> findOne(@PathVariable Long id){
        return programaService.getOne(id)
                .map(programa -> ResponseEntity.ok().body(programa))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Programa> create(@RequestBody Programa programa){
        if(programa == null) {
            return ResponseEntity.noContent().build();
        }
        
        Programa programaCreated = programaService.create(programa);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(programaCreated.getId()).toUri();

		return ResponseEntity.created(location).body(programaCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Programa> update(@PathVariable Long id, @RequestBody Programa programa){
        Optional<Programa> programaUpdated = programaService.getOne(id);

        if(programaUpdated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
		if(programa == null) {
		    return ResponseEntity.noContent().build();
		}
		
		programa.setId(programaUpdated.get().getId());
		return ResponseEntity.ok(programaService.update(programa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        return programaService.getOne(id)
                .map(programa -> {
                	programaService.delete(id);
                    return ResponseEntity.ok().body(id);
                }).orElse(ResponseEntity.notFound().build());
    }
    // == CRUD HTTP methods ==


    // == HATEOAS HTTP methods ==

    // == HATEOAS HTTP methods ==


    // == Specific HTTP methods ==
    @GetMapping("/port")
    public Integer getPort(){
        return Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")));
    }
    // == Specific HTTP methods ==

}
