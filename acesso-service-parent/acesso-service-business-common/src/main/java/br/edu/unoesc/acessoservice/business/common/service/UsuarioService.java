package br.edu.unoesc.acessoservice.business.common.service;

import java.util.Optional;

import br.edu.unoesc.acessoservice.common.model.Usuario;
import br.edu.unoesc.sistemautils.arquitetura.business.common.ICrudService;

public interface UsuarioService extends ICrudService<Usuario> {

	Usuario getOneByLogin(String login);

	Optional<Usuario> getUsuarioAutenticado(String login, String senha);
}
