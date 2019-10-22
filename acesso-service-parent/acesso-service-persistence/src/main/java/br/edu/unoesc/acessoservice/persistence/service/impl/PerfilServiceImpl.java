package br.edu.unoesc.acessoservice.persistence.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.unoesc.acessoservice.common.model.Perfil;
import br.edu.unoesc.acessoservice.persistence.repository.PerfilRepository;
import br.edu.unoesc.acessoservice.persistence.service.PerfilService;

@Service
public class PerfilServiceImpl implements PerfilService {

	// == fields ==
    private PerfilRepository perfilAcessoRepository;

    // == constructors ==
    @Autowired
    public PerfilServiceImpl(PerfilRepository perfilAcessoRepository){
        this.perfilAcessoRepository = perfilAcessoRepository;
    }

	@Override
	public List<Perfil> getAll() {
		return perfilAcessoRepository.findAll(Sort.by("id").ascending());
	}

	@Override
	public Optional<Perfil> getOne(Long id) {
		return perfilAcessoRepository.findById(id);
	}

	@Override
	public Perfil create(Perfil perfilAcesso) {
		return perfilAcessoRepository.save(perfilAcesso);
	}

	@Override
	public Perfil update(Perfil perfilAcesso) {
		return perfilAcessoRepository.save(perfilAcesso);
	}

	@Override
	public void delete(Long id) {
		perfilAcessoRepository.deleteById(id);
	}
}
