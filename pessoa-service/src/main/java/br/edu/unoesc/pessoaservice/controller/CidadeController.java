package br.edu.unoesc.pessoaservice.controller;

import br.edu.unoesc.pessoaservice.model.Cidade;
import br.edu.unoesc.pessoaservice.service.CidadeService;
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
@RequestMapping("/cidades")
public class CidadeController {

    // == fields ==
    private Environment environment;
    private CidadeService cidadeService;

    // == constructors ==
    @Autowired
    public CidadeController(Environment environment, CidadeService cidadeService) {
        this.environment = environment;
        this.cidadeService = cidadeService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Cidade> listAll(){
        return cidadeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id){
        return cidadeService.getOne(id)
                .map(cidade -> ResponseEntity.ok().body(cidade))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Cidade cidade){
        if(cidade == null) {
            return ResponseEntity.noContent().build();
        }
        else {
            Cidade cidadeCreated = cidadeService.create(cidade);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(cidadeCreated.getId()).toUri();

            return ResponseEntity.created(location).body(cidadeCreated);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Cidade cidade){
        Optional<Cidade> cidadeUpdated = cidadeService.getOne(id);

        if(cidadeUpdated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            if(cidade == null) {
                return ResponseEntity.noContent().build();
            }
            else {
                cidade.setId(cidadeUpdated.get().getId());
                return ResponseEntity.ok(cidadeService.update(cidade));
            }
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return cidadeService.getOne(id)
                .map(estado -> {
                    cidadeService.delete(id);
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
