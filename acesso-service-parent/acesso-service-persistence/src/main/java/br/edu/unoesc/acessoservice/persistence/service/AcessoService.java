package br.edu.unoesc.acessoservice.persistence.service;

import java.util.List;
import java.util.Optional;

import br.edu.unoesc.acessoservice.common.model.Acesso;

public interface AcessoService {

	// == service CRUD ==
    List<Acesso> getAll();
    
    Optional<Acesso> getOne(Long id);

    Acesso create(Acesso acesso);

    Acesso update(Acesso acesso);

    void delete(Long id);
}
