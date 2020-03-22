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

import br.edu.unoesc.pessoaservice.common.model.Cep;
import br.edu.unoesc.pessoaservice.persistence.service.CepService;

@RestController
@RequestMapping(value = "/pessoas/{idPessoa}/enderecos/{idEndereco}/cep")
public class PessoaEnderecoCepController {

    // == fields ==
    private Environment environment;
    //private PessoaService pessoaService;
    //private EnderecoService enderecoService;
    private CepService cepService;

    // == constructors ==
    @Autowired
    public PessoaEnderecoCepController(Environment environment, CepService cepService){
        this.environment = environment;
        //this.pessoaService = pessoaService;
        //this.enderecoService = enderecoService;
        this.cepService = cepService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Cep> listAll(){
        return cepService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cep> findOne(@PathVariable Long id){
        return cepService.getOne(id)
                .map(cep -> ResponseEntity.ok().body(cep))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cep> create(){
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
