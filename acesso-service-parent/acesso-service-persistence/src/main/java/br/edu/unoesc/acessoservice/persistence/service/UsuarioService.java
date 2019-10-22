package br.edu.unoesc.acessoservice.persistence.service;

import java.util.List;
import java.util.Optional;

import br.edu.unoesc.acessoservice.common.model.Usuario;

public interface UsuarioService {

	// == service CRUD ==
    List<Usuario> getAll();
    
    Optional<Usuario> getOne(Long id);

    Usuario create(Usuario usuario);

    Usuario update(Usuario usuario);

    void delete(Long id);
}
