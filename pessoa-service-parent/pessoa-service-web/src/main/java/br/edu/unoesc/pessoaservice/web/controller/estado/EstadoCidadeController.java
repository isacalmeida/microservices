package br.edu.unoesc.pessoaservice.web.controller.estado;

import java.net.URI;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
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

import br.edu.unoesc.pessoaservice.api.service.cep.CidadeService;
import br.edu.unoesc.pessoaservice.api.service.cep.EstadoService;
import br.edu.unoesc.pessoaservice.common.model.cep.Cidade;
import br.edu.unoesc.pessoaservice.common.model.cep.Estado;

@RestController
@RequestMapping(value = "/estados")
public class EstadoCidadeController {

    // == fields ==
    private Environment environment;
    private EstadoService estadoService;
    private CidadeService cidadeService;

    // == constructors ==
    @Autowired
    public EstadoCidadeController(Environment environment, EstadoService estadoService, CidadeService cidadeService){
        this.environment = environment;
        this.estadoService = estadoService;
        this.cidadeService = cidadeService;
    }

    // == CRUD HTTP methods ==
    @GetMapping("/{idEstado}/cidades")
    public List<Cidade> listAll(@PathVariable Long idEstado){
        return cidadeService.getAllByEstado(idEstado);
    }

    @GetMapping("/{idEstado}/cidades/{id}")
    public ResponseEntity<Cidade> findOne(@PathVariable Long idEstado, @PathVariable Long id) {
        Optional<Cidade> cidadeFind = cidadeService.getOne(id);
        if (cidadeFind.isPresent())
            if (!cidadeFind.get().getEstado().getId().equals(idEstado))
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        return cidadeFind
                .map(cidade -> ResponseEntity.ok().body(cidade))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{idEstado}/cidades")
    public ResponseEntity<Cidade> create(@PathVariable Long idEstado, @RequestBody Cidade cidade){
        if(cidade == null) {
            return ResponseEntity.noContent().build();
        }
		Optional<Estado> estado = estadoService.getOne(idEstado);
		if (estado.isEmpty()) {
		    return ResponseEntity.notFound().build();
		}
		cidade.setEstado(estado.get());
		Cidade cidadeCreated = cidadeService.create(cidade);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(cidadeCreated.getId()).toUri();

		return ResponseEntity.created(location).body(cidadeCreated);
    }

    @PutMapping("/{idEstado}/cidades/{id}")
    public ResponseEntity<Cidade> update(@PathVariable Long idEstado, @PathVariable Long id, @RequestBody Cidade cidade){
        Optional<Estado> estado = estadoService.getOne(idEstado);
        Optional<Cidade> cidadeUpdated = cidadeService.getOne(id);

        if(cidadeUpdated.isEmpty() || estado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
		if(cidade == null) {
		    return ResponseEntity.noContent().build();
		}
		cidade.setEstado(estado.get());
		cidade.setDataCriacao(cidadeUpdated.get().getDataCriacao());
		cidade.setDataAlteracao(Calendar.getInstance().getTime());
		cidade.setId(cidadeUpdated.get().getId());
		return ResponseEntity.ok(cidadeService.update(cidade));
    }

    @DeleteMapping("/{idEstado}/cidades/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long idEstado, @PathVariable Long id){
        return cidadeService.getOne(id)
                .map(cidade -> {
                    cidadeService.delete(id);
                    return ResponseEntity.ok().body(id);
                }).orElse(ResponseEntity.notFound().build());
    }
    // == CRUD HTTP methods ==


    // == HATEOAS HTTP methods ==
    @GetMapping("/{idEstado}/cidades/{id}/ativar")
    public ResponseEntity<Cidade> ativar(@PathVariable Long idEstado, @PathVariable Long id) {
        Optional<Cidade> cidade = cidadeService.getOne(id);
        Optional<Estado> estado = estadoService.getOne(idEstado);
        if (cidade.isPresent() && estado.isPresent()) {
            if (cidade.get().getEstado().getId().equals(estado.get().getId())) {
                if (cidade.get().getAtivo().equals(false)) {
                    cidade.get().setAtivo(true);
                    cidade.get().setDataAlteracao(Calendar.getInstance().getTime());
                    cidadeService.update(cidade.get());
                    return ResponseEntity.ok().body(cidade.get());
                }
				return ResponseEntity.badRequest().build();
            }
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
		return ResponseEntity.notFound().build();
    }

    @GetMapping("/{idEstado}/cidades/{id}/inativar")
    public ResponseEntity<Cidade> inativar(@PathVariable Long idEstado, @PathVariable Long id){
        Optional<Cidade> cidade = cidadeService.getOne(id);
        Optional<Estado> estado = estadoService.getOne(idEstado);
        if (cidade.isPresent() && estado.isPresent()) {
            if (cidade.get().getEstado().getId().equals(estado.get().getId())) {
                if (cidade.get().getAtivo().equals(true)) {
                    cidade.get().setAtivo(false);
                    cidade.get().setDataAlteracao(Calendar.getInstance().getTime());
                    cidadeService.update(cidade.get());
                    return ResponseEntity.ok().body(cidade.get());
                }
				return ResponseEntity.badRequest().build();
            }
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
		return ResponseEntity.notFound().build();
    }
    // == HATEOAS HTTP methods ==


    // == Specific HTTP methods ==
    @GetMapping("/{idEstado}/cidades/port")
    public Integer getPort(@PathVariable Long idEstado){
        return Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")));
    }

    @GetMapping("/sigla/{sigla}/cidades/descricao/{descricao}")
    public List<Cidade> findAllCidadeByEstado(@PathVariable String sigla, @PathVariable String descricao){
        return cidadeService.findAllCidadeBySiglaAndDescricao(sigla, descricao);
    }
    // == Specific HTTP methods ==
}
