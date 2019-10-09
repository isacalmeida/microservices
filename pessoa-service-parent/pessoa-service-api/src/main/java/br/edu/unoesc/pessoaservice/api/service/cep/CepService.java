package br.edu.unoesc.pessoaservice.api.service.cep;

import java.util.List;
import java.util.Optional;

import br.edu.unoesc.pessoaservice.common.model.cep.Cep;

public interface CepService {

    // == service CRUD ==
    List<Cep> getAll();

    List<Cep> getAllByEstadoAndCidade(Long idEstado, Long idCidade);

    List<Cep> getAllByCep(String cep);

    Optional<Cep> getOne(Long id);

    Cep create(Cep cep);

    Cep update(Cep cep);

    void delete(Long id);
}
