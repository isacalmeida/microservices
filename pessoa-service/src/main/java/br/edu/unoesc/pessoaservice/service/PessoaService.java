package br.edu.unoesc.pessoaservice.service;

import br.edu.unoesc.pessoaservice.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {

    // == service CRUD ==
    List<Pessoa> getAll();

    Optional<Pessoa> getOne(Long id);

    Pessoa create(Pessoa pessoa);

    Pessoa update(Pessoa pessoa);

    void delete(Long id);
}
