package br.edu.unoesc.pessoaservice.service;

import br.edu.unoesc.pessoaservice.model.Endereco;

import java.util.List;
import java.util.Optional;

public interface EnderecoService {

    // == service CRUD ==
    List<Endereco> getAll();

    Optional<Endereco> getOne(Long id);

    Endereco create(Endereco endereco);

    Endereco update(Endereco endereco);

    void delete(Long id);
}
