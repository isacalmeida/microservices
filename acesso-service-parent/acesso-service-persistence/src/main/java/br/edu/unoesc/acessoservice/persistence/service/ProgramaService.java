package br.edu.unoesc.acessoservice.persistence.service;

import java.util.List;
import java.util.Optional;

import br.edu.unoesc.acessoservice.common.model.Programa;

public interface ProgramaService {

	// == service CRUD ==
    List<Programa> getAll();
    
    Optional<Programa> getOne(Long id);

    Programa create(Programa programa);

    Programa update(Programa programa);

    void delete(Long id);
}
