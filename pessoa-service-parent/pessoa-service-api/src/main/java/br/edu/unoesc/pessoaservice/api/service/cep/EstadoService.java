package br.edu.unoesc.pessoaservice.api.service.cep;

import java.util.List;
import java.util.Optional;

import br.edu.unoesc.pessoaservice.common.model.cep.Estado;

public interface EstadoService {

    // == service CRUD ==
    List<Estado> getAll();

    Optional<Estado> getOne(Long id);

    Estado create(Estado estado);

    Estado update(Estado estado);

    void delete(Long id);
}