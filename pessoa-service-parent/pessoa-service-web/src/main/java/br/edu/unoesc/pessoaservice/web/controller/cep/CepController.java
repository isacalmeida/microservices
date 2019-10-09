package br.edu.unoesc.pessoaservice.web.controller.cep;

import java.net.URI;
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

import br.edu.unoesc.pessoaservice.api.service.cep.CepService;
import br.edu.unoesc.pessoaservice.common.model.cep.Cep;

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
    public ResponseEntity<Cep> findOne(@PathVariable Long id){
        return cepService.getOne(id)
                .map(cep -> ResponseEntity.ok().body(cep))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cep> create(@RequestBody Cep cep){
        if(cep == null) {
            return ResponseEntity.noContent().build();
        }
        
		Cep cepCreated = cepService.create(cep);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(cepCreated.getId()).toUri();

		return ResponseEntity.created(location).body(cepCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cep> update(@PathVariable Long id, @RequestBody Cep cep){
        Optional<Cep> cepUpdated = cepService.getOne(id);

        if(cepUpdated.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
		if(cep == null) {
		    return ResponseEntity.noContent().build();
		}
		
		cep.setId(cepUpdated.get().getId());
		return ResponseEntity.ok(cepService.update(cep));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
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
