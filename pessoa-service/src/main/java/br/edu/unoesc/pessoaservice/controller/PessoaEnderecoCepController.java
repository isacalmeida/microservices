package br.edu.unoesc.pessoaservice.controller;

import br.edu.unoesc.pessoaservice.model.Cep;
import br.edu.unoesc.pessoaservice.service.CepService;
import br.edu.unoesc.pessoaservice.service.EnderecoService;
import br.edu.unoesc.pessoaservice.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas/{idPessoa}/enderecos/{idEndereco}/cep", consumes = "application/json", produces = "application/json")
public class PessoaEnderecoCepController {

    // == fields ==
    private PessoaService pessoaService;
    private EnderecoService enderecoService;
    private CepService cepService;

    // == constructors ==
    @Autowired
    public PessoaEnderecoCepController(PessoaService pessoaService, EnderecoService enderecoService, CepService cepService){
        this.pessoaService = pessoaService;
        this.enderecoService = enderecoService;
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
                .map(cep -> ResponseEntity.ok().body(cep))
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
