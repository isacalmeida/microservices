package br.edu.unoesc.acessoservice.business.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unoesc.acessoservice.business.common.service.UsuarioService;
import br.edu.unoesc.acessoservice.common.model.Usuario;
import br.edu.unoesc.acessoservice.persistence.repository.UsuarioRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractCrudService;

@Service
public class UsuarioServiceImpl extends AbstractCrudService<Usuario, UsuarioRepository> implements UsuarioService {

	@Override
	public Usuario getOneByLogin(String login) {
		return getRepository().findByLoginAndIsExcluido(login, Boolean.FALSE);
	}

	@Override
	public Optional<Usuario> getUsuarioAutenticado(String login, String senha) {
		return getRepository().findByLoginAndSenhaAndIsExcluido(login, senha, Boolean.FALSE);
	}
}
