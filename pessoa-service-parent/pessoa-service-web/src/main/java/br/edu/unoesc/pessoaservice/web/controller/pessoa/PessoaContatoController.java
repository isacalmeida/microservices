package br.edu.unoesc.pessoaservice.web.controller.pessoa;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.api.service.pessoa.ContatoService;
import br.edu.unoesc.pessoaservice.common.model.pessoa.Contato;

@RestController
@RequestMapping(value = "/pessoas/{idPessoa}/contatos")
public class PessoaContatoController {

    // == fields ==
    private Environment environment;
    //private PessoaService pessoaService;
    private ContatoService contatoService;

    // == constructors ==
    @Autowired
    public PessoaContatoController(Environment environment, ContatoService contatoService){
        this.environment = environment;
        //this.pessoaService = pessoaService;
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
