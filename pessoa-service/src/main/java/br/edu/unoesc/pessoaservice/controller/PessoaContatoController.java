package br.edu.unoesc.pessoaservice.controller;

import br.edu.unoesc.pessoaservice.model.Contato;
import br.edu.unoesc.pessoaservice.service.ContatoService;
import br.edu.unoesc.pessoaservice.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas/{idPessoa}/contatos", consumes = "application/json", produces = "application/json")
public class PessoaContatoController {

    // == fields ==
    private PessoaService pessoaService;
    private ContatoService contatoService;

    // == constructors ==
    @Autowired
    public PessoaContatoController(PessoaService pessoaService, ContatoService contatoService){
        this.pessoaService = pessoaService;
        this.contatoService = contatoService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Contato> listAll(){
        return contatoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id){
        return contatoService.getOne(id)
                .map(contato -> ResponseEntity.ok().body(contato))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity create(){
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id){
        return ResponseEntity.ok().body(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok().body(id);
    }
    // == CRUD HTTP methods ==


    // == HATEOAS HTTP methods ==

    // == HATEOAS HTTP methods ==
}
