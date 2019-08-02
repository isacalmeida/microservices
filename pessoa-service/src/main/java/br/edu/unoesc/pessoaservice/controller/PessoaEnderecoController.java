package br.edu.unoesc.pessoaservice.controller;

import br.edu.unoesc.pessoaservice.model.Endereco;
import br.edu.unoesc.pessoaservice.service.EnderecoService;
import br.edu.unoesc.pessoaservice.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/pessoas/{idPessoa}/enderecos")
public class PessoaEnderecoController {

    // == fields ==
    private Environment environment;
    private PessoaService pessoaService;
    private EnderecoService enderecoService;

    // == constructors ==
    @Autowired
    public PessoaEnderecoController(Environment environment, PessoaService pessoaService, EnderecoService enderecoService){
        this.environment = environment;
        this.pessoaService = pessoaService;
        this.enderecoService = enderecoService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Endereco> listAll(){
        return enderecoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id){
        return enderecoService.getOne(id)
                .map(endereco -> ResponseEntity.ok().body(endereco))
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


    // == Specific HTTP methods ==
    @GetMapping("/port")
    public Integer getPort(){
        return Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")));
    }
    // == Specific HTTP methods ==
}
