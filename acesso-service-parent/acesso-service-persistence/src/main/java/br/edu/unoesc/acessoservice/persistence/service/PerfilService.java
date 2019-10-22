package br.edu.unoesc.acessoservice.persistence.service;

import java.util.List;
import java.util.Optional;

import br.edu.unoesc.acessoservice.common.model.Perfil;

public interface PerfilService {

	// == service CRUD ==
    List<Perfil> getAll();
    
    Optional<Perfil> getOne(Long id);

    Perfil create(Perfil perfilAcesso);

    Perfil update(Perfil perfilAcesso);

    void delete(Long id);
}
