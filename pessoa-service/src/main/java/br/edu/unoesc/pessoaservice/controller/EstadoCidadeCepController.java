package br.edu.unoesc.pessoaservice.controller;

import br.edu.unoesc.pessoaservice.model.Cep;
import br.edu.unoesc.pessoaservice.model.Cidade;
import br.edu.unoesc.pessoaservice.model.Estado;
import br.edu.unoesc.pessoaservice.service.CepService;
import br.edu.unoesc.pessoaservice.service.CidadeService;
import br.edu.unoesc.pessoaservice.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/estados/{idEstado}/cidades/{idCidade}/ceps")
public class EstadoCidadeCepController {

    // == fields ==
    private Environment environment;
    private EstadoService estadoService;
    private CidadeService cidadeService;
    private CepService cepService;

    // == constructors ==
    @Autowired
    public EstadoCidadeCepController(Environment environment, EstadoService estadoService, CidadeService cidadeService, CepService cepService){
        this.environment = environment;
        this.estadoService = estadoService;
        this.cidadeService = cidadeService;
        this.cepService = cepService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Cep> listAll(@PathVariable Long idEstado, @PathVariable Long idCidade){
        return cepService.getAllByEstadoAndCidade(idEstado, idCidade);
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long idEstado, @PathVariable Long idCidade, @PathVariable Long id){
        Optional<Cep> cepFind = cepService.getOne(id);
        if (cepFind.isPresent())
            if (!cepFind.get().getCidade().getEstado().getId().equals(idEstado))
                if(!cepFind.get().getCidade().getId().equals(idCidade))
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        return cepFind
                .map(cep -> ResponseEntity.ok().body(cep))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity create(@PathVariable Long idEstado, @PathVariable Long idCidade, @RequestBody Cep cep){
        if(cep == null) {
            return ResponseEntity.noContent().build();
        }
        else {
            Optional<Estado> estado = estadoService.getOne(idEstado);
            if (estado.isEmpty())
                return ResponseEntity.notFound().build();
            Optional<Cidade> cidade = cidadeService.getOne(idCidade);
            if (cidade.isEmpty())
                return ResponseEntity.notFound().build();

            cidade.get().setEstado(estado.get());
            cep.setCidade(cidade.get());

            Cep cepCreated = cepService.create(cep);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(cepCreated.getId()).toUri();

            return ResponseEntity.created(location).body(cepCreated);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long idEstado, @PathVariable Long idCidade, @PathVariable Long id, @RequestBody Cep cep){
        Optional<Estado> estado = estadoService.getOne(idEstado);
        Optional<Cidade> cidade = cidadeService.getOne(idCidade);
        Optional<Cep> cepUpdated = cepService.getOne(id);

        if(cepUpdated.isEmpty() || cidade.isEmpty() || estado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            if(cep == null) {
                return ResponseEntity.noContent().build();
            }
            else {
                cidade.get().setEstado(estado.get());
                cep.setCidade(cidade.get());
                cep.setDataCriacao(cepUpdated.get().getDataCriacao());
                cep.setDataAlteracao(Calendar.getInstance().getTime());
                cep.setId(cepUpdated.get().getId());
                return ResponseEntity.ok(cepService.update(cep));
            }
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long idEstado, @PathVariable Long idCidade, @PathVariable Long id){
        return cepService.getOne(id)
                .map(cep -> {
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
    // == Specific HTTP methods ==
}
