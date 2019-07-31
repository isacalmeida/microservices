package br.edu.unoesc.pessoaservice.service;

import br.edu.unoesc.pessoaservice.model.Estado;
import br.edu.unoesc.pessoaservice.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoServiceImpl implements EstadoService{

    // == fields ==
    private EstadoRepository estadoRepository;

    // == constructors ==
    @Autowired
    public EstadoServiceImpl(EstadoRepository estadoRepository){
        this.estadoRepository = estadoRepository;
    }

    @Override
    public List<Estado> getAll() {
        return estadoRepository.findAll(Sort.by("id").ascending());
    }

    @Override
    public Optional<Estado> getOne(Long id) {
        return estadoRepository.findById(id);
    }

    @Override
    public Estado create(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Override
    public Estado update(Estado estado) {
        return estadoRepository.save(estado);
    }

    @Override
    public void delete(Long id) {
        estadoRepository.deleteById(id);
    }
}
