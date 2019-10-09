package br.edu.unoesc.pessoaservice.api.service.pessoa;

import java.util.List;
import java.util.Optional;

import br.edu.unoesc.pessoaservice.common.model.pessoa.Endereco;

public interface EnderecoService {

    // == service CRUD ==
    List<Endereco> getAll();

    Optional<Endereco> getOne(Long id);

    Endereco create(Endereco endereco);

    Endereco update(Endereco endereco);

    void delete(Long id);
}
