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

import br.edu.unoesc.acessoservice.common.model.Usuario;
import br.edu.unoesc.acessoservice.persistence.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    // == fields ==
    private Environment environment;
    private UsuarioService usuarioService;

    // == constructors ==
    @Autowired
    public UsuarioController(Environment environment, UsuarioService usuarioService) {
        this.environment = environment;
        this.usuarioService = usuarioService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Usuario> listAll(){
        return usuarioService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findOne(@PathVariable Long id){
        return usuarioService.getOne(id)
                .map(usuario -> ResponseEntity.ok().body(usuario))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        if(usuario == null) {
            return ResponseEntity.noContent().build();
        }
        
        Usuario usuarioCreated = usuarioService.create(usuario);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(usuarioCreated.getId()).toUri();

		return ResponseEntity.created(location).body(usuarioCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        Optional<Usuario> usuarioUpdated = usuarioService.getOne(id);

        if(usuarioUpdated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
		if(usuario == null) {
		    return ResponseEntity.noContent().build();
		}
		
		usuario.setId(usuarioUpdated.get().getId());
		return ResponseEntity.ok(usuarioService.update(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        return usuarioService.getOne(id)
                .map(usuario -> {
                	usuarioService.delete(id);
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
