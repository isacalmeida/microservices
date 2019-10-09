package br.edu.unoesc.pessoaservice.web.controller.pessoa;

import java.net.URI;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.unoesc.pessoaservice.api.service.pessoa.PessoaService;
import br.edu.unoesc.pessoaservice.common.model.pessoa.Pessoa;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    // == fields ==
    private Environment environment;
    private PessoaService pessoaService;

    // == constructor ==
    @Autowired
    public PessoaController(Environment environment, PessoaService pessoaService){
        this.environment = environment;
        this.pessoaService = pessoaService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Pessoa> listAll(){
        return pessoaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findOne(@PathVariable Long id){
        return pessoaService.getOne(id)
                .map(pessoa -> ResponseEntity.ok().body(pessoa))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa){
        if(pessoa == null) {
            return ResponseEntity.noContent().build();
        }
		Pessoa pessoaCreated = pessoaService.create(pessoa);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(pessoaCreated.getId()).toUri();

		return ResponseEntity.created(location).body(pessoaCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa){
        Optional<Pessoa> pessoaUpdated = pessoaService.getOne(id);

        if(pessoaUpdated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
		if(pessoa == null) {
		    return ResponseEntity.noContent().build();
		}
		pessoa.setId(pessoaUpdated.get().getId());
		pessoa.setDataAlteracao(Calendar.getInstance().getTime());
		return ResponseEntity.ok(pessoaService.update(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        return pessoaService.getOne(id)
                .map(pessoa -> {
                    pessoaService.delete(id);
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
