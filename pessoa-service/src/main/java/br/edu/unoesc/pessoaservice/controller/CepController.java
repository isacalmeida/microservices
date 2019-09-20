package br.edu.unoesc.pessoaservice.controller;

import br.edu.unoesc.pessoaservice.model.Cep;
import br.edu.unoesc.pessoaservice.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/ceps")
public class CepController {

    // == fields ==
    private Environment environment;
    private CepService cepService;

    // == constructors ==
    @Autowired
    public CepController(Environment environment, CepService cepService) {
        this.environment = environment;
        this.cepService = cepService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Cep> listAll(){
        return cepService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id){
        return cepService.getOne(id)
                .map(estado -> ResponseEntity.ok().body(estado))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Cep cep){
        if(cep == null) {
            return ResponseEntity.noContent().build();
        }
        else {
            Cep cepCreated = cepService.create(cep);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(cepCreated.getId()).toUri();

            return ResponseEntity.created(location).body(cepCreated);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Cep cep){
        Optional<Cep> cepUpdated = cepService.getOne(id);

        if(cepUpdated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            if(cep == null) {
                return ResponseEntity.noContent().build();
            }
            else {
                cep.setId(cepUpdated.get().getId());
                return ResponseEntity.ok(cepService.update(cep));
            }
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return cepService.getOne(id)
                .map(estado -> {
                    cepService.delete(id);
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

    @GetMapping("/{query}/query")
    public List<Cep> getAllByQueryCep(@PathVariable String query){
        return cepService.getAllByCep(query);
    }
    // == Specific HTTP methods ==

}
