package br.edu.unoesc.pessoaservice.controller;

import br.edu.unoesc.pessoaservice.model.Contato;
import br.edu.unoesc.pessoaservice.service.ContatoService;
import br.edu.unoesc.pessoaservice.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/pessoas/{idPessoa}/contatos", consumes = "application/json", produces = "application/json")
public class PessoaContatoController {

    // == fields ==
    private Environment environment;
    private PessoaService pessoaService;
    private ContatoService contatoService;

    // == constructors ==
    @Autowired
    public PessoaContatoController(Environment environment, PessoaService pessoaService, ContatoService contatoService){
        this.environment = environment;
        this.pessoaService = pessoaService;
        this.contatoService = contatoService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Contato> listAll(){
        return contatoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> findOne(@PathVariable Long id){
        return contatoService.getOne(id)
                .map(contato -> ResponseEntity.ok().body(contato))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contato> create(){
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id){
        return ResponseEntity.ok().body(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        return ResponseEntity.ok().body(id);
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
