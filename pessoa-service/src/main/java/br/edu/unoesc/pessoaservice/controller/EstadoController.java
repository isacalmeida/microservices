package br.edu.unoesc.pessoaservice.controller;

import br.edu.unoesc.pessoaservice.model.Estado;
import br.edu.unoesc.pessoaservice.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    // == fields ==
    private EstadoService estadoService;

    // == constructors ==
    @Autowired
    public EstadoController(EstadoService estadoService){
        this.estadoService = estadoService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Estado> listAll(){
        return estadoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id){
        return estadoService.getOne(id)
                .map(estado -> ResponseEntity.ok().body(estado))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Estado estado){
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
    public ResponseEntity update(@PathVariable Long id, @RequestBody Estado estado){
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
                return ResponseEntity.ok(estadoService.update(estado));
            }
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return estadoService.getOne(id)
                .map(estado -> {
                    estadoService.delete(id);
                    return ResponseEntity.ok().body(id);
                }).orElse(ResponseEntity.notFound().build());
    }
    // == CRUD HTTP methods ==


    // == HATEOAS HTTP methods ==

    // == HATEOAS HTTP methods ==
}
