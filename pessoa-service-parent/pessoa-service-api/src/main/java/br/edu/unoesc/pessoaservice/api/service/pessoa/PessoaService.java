package br.edu.unoesc.pessoaservice.api.service.pessoa;

import java.util.List;
import java.util.Optional;

import br.edu.unoesc.pessoaservice.common.model.pessoa.Pessoa;

public interface PessoaService {

    // == service CRUD ==
    List<Pessoa> getAll();

    Optional<Pessoa> getOne(Long id);

    Pessoa create(Pessoa pessoa);

    Pessoa update(Pessoa pessoa);

    void delete(Long id);
}
