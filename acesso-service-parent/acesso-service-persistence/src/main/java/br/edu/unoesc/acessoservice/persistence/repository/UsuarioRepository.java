package br.edu.unoesc.acessoservice.persistence.repository;

import java.util.Optional;

import br.edu.unoesc.acessoservice.common.model.Usuario;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.ICrudRepository;

public interface UsuarioRepository extends ICrudRepository<Usuario, Long> {

	Usuario findByLoginAndIsExcluido(String login, Boolean isExcluido);

	Optional<Usuario> findByLoginAndSenhaAndIsExcluido(String login, String senha, Boolean isExcluido);
}
