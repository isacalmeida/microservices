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

import br.edu.unoesc.acessoservice.common.model.Acesso;
import br.edu.unoesc.acessoservice.persistence.service.AcessoService;

@RestController
@RequestMapping("/acessos")
public class AcessoController {

    // == fields ==
    private Environment environment;
    private AcessoService acessoService;

    // == constructors ==
    @Autowired
    public AcessoController(Environment environment, AcessoService acessoService) {
        this.environment = environment;
        this.acessoService = acessoService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Acesso> listAll(){
        return acessoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acesso> findOne(@PathVariable Long id){
        return acessoService.getOne(id)
                .map(acesso -> ResponseEntity.ok().body(acesso))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Acesso> create(@RequestBody Acesso acesso){
        if(acesso == null) {
            return ResponseEntity.noContent().build();
        }
        
        Acesso acessoCreated = acessoService.create(acesso);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(acessoCreated.getId()).toUri();

		return ResponseEntity.created(location).body(acessoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acesso> update(@PathVariable Long id, @RequestBody Acesso acesso){
        Optional<Acesso> acessoUpdated = acessoService.getOne(id);

        if(acessoUpdated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
		if(acesso == null) {
		    return ResponseEntity.noContent().build();
		}
		
		acesso.setId(acessoUpdated.get().getId());
		return ResponseEntity.ok(acessoService.update(acesso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        return acessoService.getOne(id)
                .map(acesso -> {
                	acessoService.delete(id);
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
