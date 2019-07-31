package br.edu.unoesc.pessoaservice.controller;

import br.edu.unoesc.pessoaservice.model.Cidade;
import br.edu.unoesc.pessoaservice.model.Estado;
import br.edu.unoesc.pessoaservice.service.CidadeService;
import br.edu.unoesc.pessoaservice.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estados/{idEstado}/cidades")
public class EstadoCidadeController {

    // == fields ==
    private EstadoService estadoService;
    private CidadeService cidadeService;

    // == constructors ==
    @Autowired
    public EstadoCidadeController(EstadoService estadoService, CidadeService cidadeService){
        this.estadoService = estadoService;
        this.cidadeService = cidadeService;
    }

    // == CRUD HTTP methods ==
    @GetMapping
    public List<Cidade> listAll(@PathVariable Long idEstado){
        return cidadeService.getAllByEstado(idEstado);
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long idEstado, @PathVariable Long id) {
        Optional<Cidade> cidadeFind = cidadeService.getOne(id);
        if (cidadeFind.isPresent())
            if (!cidadeFind.get().getEstado().getId().equals(idEstado))
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        return cidadeFind
                .map(cidade -> ResponseEntity.ok().body(cidade))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity create(@PathVariable Long idEstado, @RequestBody Cidade cidade){
        if(cidade == null) {
            return ResponseEntity.noContent().build();
        }
        else {
            Optional<Estado> estado = estadoService.getOne(idEstado);
            if (estado.isEmpty())
                return ResponseEntity.notFound().build();

            cidade.setEstado(estado.get());
            Cidade cidadeCreated = cidadeService.create(cidade);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(cidadeCreated.getId()).toUri();

            return ResponseEntity.created(location).body(cidadeCreated);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long idEstado, @PathVariable Long id, @RequestBody Cidade cidade){
        Optional<Estado> estado = estadoService.getOne(idEstado);
        Optional<Cidade> cidadeUpdated = cidadeService.getOne(id);

        if(cidadeUpdated.isEmpty() || estado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            if(cidade == null) {
                return ResponseEntity.noContent().build();
            }
            else {
                cidade.setEstado(estado.get());
                cidade.setDataCriacao(cidadeUpdated.get().getDataCriacao());
                cidade.setDataAlteracao(Calendar.getInstance().getTime());
                cidade.setId(cidadeUpdated.get().getId());
                return ResponseEntity.ok(cidadeService.update(cidade));
            }
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long idEstado, @PathVariable Long id){
        return cidadeService.getOne(id)
                .map(cidade -> {
                    cidadeService.delete(id);
                    return ResponseEntity.ok().body(id);
                }).orElse(ResponseEntity.notFound().build());
    }
    // == CRUD HTTP methods ==


    // == HATEOAS HTTP methods ==
    @GetMapping("/{id}/ativar")
    public ResponseEntity ativar(@PathVariable Long idEstado, @PathVariable Long id) {
        Optional<Cidade> cidade = cidadeService.getOne(id);
        Optional<Estado> estado = estadoService.getOne(idEstado);
        if (cidade.isPresent() && estado.isPresent()) {
            if (cidade.get().getEstado().getId().equals(estado.get().getId())) {
                if (cidade.get().getAtivo().equals(false)) {
                    cidade.get().setAtivo(true);
                    cidade.get().setDataAlteracao(Calendar.getInstance().getTime());
                    cidadeService.update(cidade.get());
                    return ResponseEntity.ok().body(cidade.get());
                } else {
                    return ResponseEntity.badRequest().build();
                }
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/inativar")
    public ResponseEntity inativar(@PathVariable Long idEstado, @PathVariable Long id){
        Optional<Cidade> cidade = cidadeService.getOne(id);
        Optional<Estado> estado = estadoService.getOne(idEstado);
        if (cidade.isPresent() && estado.isPresent()) {
            if (cidade.get().getEstado().getId().equals(estado.get().getId())) {
                if (cidade.get().getAtivo().equals(true)) {
                    cidade.get().setAtivo(false);
                    cidade.get().setDataAlteracao(Calendar.getInstance().getTime());
                    cidadeService.update(cidade.get());
                    return ResponseEntity.ok().body(cidade.get());
                } else {
                    return ResponseEntity.badRequest().build();
                }
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    // == HATEOAS HTTP methods ==
}
