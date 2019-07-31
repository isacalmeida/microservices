package br.edu.unoesc.pessoaservice.controller;

import br.edu.unoesc.pessoaservice.model.Pessoa;
import br.edu.unoesc.pessoaservice.repository.PessoaRepository;
import br.edu.unoesc.pessoaservice.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    // == fields ==
    private PessoaService pessoaService;

    // == constructor ==
    @Autowired
    public PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Pessoa> listAll(){
        return pessoaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id){
        return pessoaService.getOne(id)
                .map(pessoa -> ResponseEntity.ok().body(pessoa))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Pessoa pessoa){
        if(pessoa == null) {
            return ResponseEntity.noContent().build();
        }
        else {
            Pessoa pessoaCreated = pessoaService.create(pessoa);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(pessoaCreated.getId()).toUri();

            return ResponseEntity.created(location).body(pessoaCreated);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Pessoa pessoa){
        Optional<Pessoa> pessoaUpdated = pessoaService.getOne(id);

        if(pessoaUpdated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            if(pessoa == null) {
                return ResponseEntity.noContent().build();
            }
            else {
                pessoa.setId(pessoaUpdated.get().getId());
                return ResponseEntity.ok(pessoaService.update(pessoa));
            }
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return pessoaService.getOne(id)
                .map(pessoa -> {
                    pessoaService.delete(id);
                    return ResponseEntity.ok().body(id);
                }).orElse(ResponseEntity.notFound().build());
    }
    // == CRUD HTTP methods ==


    // == HATEOAS HTTP methods ==

    // == HATEOAS HTTP methods ==
}
