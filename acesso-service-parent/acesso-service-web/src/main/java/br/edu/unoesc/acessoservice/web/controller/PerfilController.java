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

import br.edu.unoesc.acessoservice.common.model.Perfil;
import br.edu.unoesc.acessoservice.persistence.service.PerfilService;

@RestController
@RequestMapping("/perfis")
public class PerfilController {

    // == fields ==
    private Environment environment;
    private PerfilService perfilService;

    // == constructors ==
    @Autowired
    public PerfilController(Environment environment, PerfilService perfilService) {
        this.environment = environment;
        this.perfilService = perfilService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Perfil> listAll(){
        return perfilService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> findOne(@PathVariable Long id){
        return perfilService.getOne(id)
                .map(perfil -> ResponseEntity.ok().body(perfil))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Perfil> create(@RequestBody Perfil perfil){
        if(perfil == null) {
            return ResponseEntity.noContent().build();
        }
        
        Perfil perfilCreated = perfilService.create(perfil);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(perfilCreated.getId()).toUri();

		return ResponseEntity.created(location).body(perfilCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfil> update(@PathVariable Long id, @RequestBody Perfil perfil){
        Optional<Perfil> perfilUpdated = perfilService.getOne(id);

        if(perfilUpdated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
		if(perfil == null) {
		    return ResponseEntity.noContent().build();
		}
		
		perfil.setId(perfilUpdated.get().getId());
		return ResponseEntity.ok(perfilService.update(perfil));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        return perfilService.getOne(id)
                .map(perfil -> {
                	perfilService.delete(id);
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
