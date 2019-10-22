package br.edu.unoesc.pessoaservice.web.controller.estado;

import java.net.URI;
import java.util.Calendar;
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

import br.edu.unoesc.pessoaservice.common.model.cep.Estado;
import br.edu.unoesc.pessoaservice.persistence.service.cep.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    // == fields ==
    private Environment environment;
    private EstadoService estadoService;

    // == constructors ==
    @Autowired
    public EstadoController(Environment environment, EstadoService estadoService){
        this.environment = environment;
        this.estadoService = estadoService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Estado> listAll(){
        return estadoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> findOne(@PathVariable Long id){
        return estadoService.getOne(id)
                .map(estado -> ResponseEntity.ok().body(estado))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estado> create(@RequestBody Estado estado){
        if(estado == null) {
            return ResponseEntity.noContent().build();
        }
		Estado estadoCreated = estadoService.create(estado);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(estadoCreated.getId()).toUri();

		return ResponseEntity.created(location).body(estadoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> update(@PathVariable Long id, @RequestBody Estado estado){
        Optional<Estado> estadoUpdated = estadoService.getOne(id);

        if(estadoUpdated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
		if(estado == null) {
		    return ResponseEntity.noContent().build();
		}
		estado.setId(estadoUpdated.get().getId());
		estado.setDataAlteracao(Calendar.getInstance().getTime());
		return ResponseEntity.ok(estadoService.update(estado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        return estadoService.getOne(id)
                .map(estado -> {
                    estadoService.delete(id);
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
