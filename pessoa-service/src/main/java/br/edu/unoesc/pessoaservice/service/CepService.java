package br.edu.unoesc.pessoaservice.service;

import br.edu.unoesc.pessoaservice.model.Cep;

import java.util.List;
import java.util.Optional;

public interface CepService {

    // == service CRUD ==
    List<Cep> getAll();

    Optional<Cep> getOne(Long id);

    Cep create(Cep cep);

    Cep update(Cep cep);

    void delete(Long id);
}
