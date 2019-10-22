package br.edu.unoesc.acessoservice.persistence.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.unoesc.acessoservice.common.model.Acesso;
import br.edu.unoesc.acessoservice.persistence.repository.AcessoRepository;
import br.edu.unoesc.acessoservice.persistence.service.AcessoService;

@Service
public class AcessoServiceImpl implements AcessoService {

	// == fields ==
    private AcessoRepository acessoRepository;

    // == constructors ==
    @Autowired
    public AcessoServiceImpl(AcessoRepository acessoRepository){
        this.acessoRepository = acessoRepository;
    }

	@Override
	public List<Acesso> getAll() {
		return acessoRepository.findAll(Sort.by("id").ascending());
	}

	@Override
	public Optional<Acesso> getOne(Long id) {
		return acessoRepository.findById(id);
	}

	@Override
	public Acesso create(Acesso acesso) {
		return acessoRepository.save(acesso);
	}

	@Override
	public Acesso update(Acesso acesso) {
		return acessoRepository.save(acesso);
	}

	@Override
	public void delete(Long id) {
		acessoRepository.deleteById(id);
	}
}
