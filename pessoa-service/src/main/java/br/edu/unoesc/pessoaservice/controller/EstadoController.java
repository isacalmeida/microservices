package br.edu.unoesc.pessoaservice.controller;

import br.edu.unoesc.pessoaservice.model.Estado;
import br.edu.unoesc.pessoaservice.service.EstadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
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
        else {
            Estado estadoCreated = estadoService.create(estado);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(estadoCreated.getId()).toUri();

            return ResponseEntity.created(location).body(estadoCreated);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> update(@PathVariable Long id, @RequestBody Estado estado){
        Optional<Estado> estadoUpdated = estadoService.getOne(id);

        if(estadoUpdated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            if(estado == null) {
                return ResponseEntity.noContent().build();
            }
            else {
                estado.setId(estadoUpdated.get().getId());
                estado.setDataAlteracao(Calendar.getInstance().getTime());
                return ResponseEntity.ok(estadoService.update(estado));
            }
        }
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
