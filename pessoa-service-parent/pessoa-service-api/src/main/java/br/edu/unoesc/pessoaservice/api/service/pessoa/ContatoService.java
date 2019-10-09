package br.edu.unoesc.pessoaservice.api.service.pessoa;

import java.util.List;
import java.util.Optional;

import br.edu.unoesc.pessoaservice.common.model.pessoa.Contato;

public interface ContatoService {

    // == service CRUD ==
    List<Contato> getAll();

    Optional<Contato> getOne(Long id);

    Contato create(Contato contato);

    Contato update(Contato contato);

    void delete(Long id);
}
