package br.edu.unoesc.pessoaservice.service;

import br.edu.unoesc.pessoaservice.model.Contato;

import java.util.List;
import java.util.Optional;

public interface ContatoService {

    // == service CRUD ==
    List<Contato> getAll();

    Optional<Contato> getOne(Long id);

    Contato create(Contato contato);

    Contato update(Contato contato);

    void delete(Long id);
}
