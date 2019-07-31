package br.edu.unoesc.pessoaservice.service;

import br.edu.unoesc.pessoaservice.model.Estado;

import java.util.List;
import java.util.Optional;

public interface EstadoService {

    // == service CRUD ==
    List<Estado> getAll();

    Optional<Estado> getOne(Long id);

    Estado create(Estado estado);

    Estado update(Estado estado);

    void delete(Long id);
}
