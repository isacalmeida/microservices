package br.edu.unoesc.acessoservice.persistence.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.unoesc.acessoservice.common.model.Programa;
import br.edu.unoesc.acessoservice.persistence.repository.ProgramaRepository;
import br.edu.unoesc.acessoservice.persistence.service.ProgramaService;

@Service
public class ProgramaServiceImpl implements ProgramaService {

	// == fields ==
    private ProgramaRepository programaRepository;

    // == constructors ==
    @Autowired
    public ProgramaServiceImpl(ProgramaRepository programaRepository){
        this.programaRepository = programaRepository;
    }

	@Override
	public List<Programa> getAll() {
		return programaRepository.findAll(Sort.by("id").ascending());
	}

	@Override
	public Optional<Programa> getOne(Long id) {
		return programaRepository.findById(id);
	}

	@Override
	public Programa create(Programa programa) {
		return programaRepository.save(programa);
	}

	@Override
	public Programa update(Programa programa) {
		return programaRepository.save(programa);
	}

	@Override
	public void delete(Long id) {
		programaRepository.deleteById(id);
	}
}
