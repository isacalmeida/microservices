package br.edu.unoesc.acessoservice.persistence.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.unoesc.acessoservice.common.model.Usuario;
import br.edu.unoesc.acessoservice.persistence.repository.UsuarioRepository;
import br.edu.unoesc.acessoservice.persistence.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	// == fields ==
    private UsuarioRepository usuarioRepository;

    // == constructors ==
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

	@Override
	public List<Usuario> getAll() {
		return usuarioRepository.findAll(Sort.by("id").ascending());
	}

	@Override
	public Optional<Usuario> getOne(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public Usuario create(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}
}
