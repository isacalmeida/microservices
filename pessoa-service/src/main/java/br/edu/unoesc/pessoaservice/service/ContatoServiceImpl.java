package br.edu.unoesc.pessoaservice.service;

import br.edu.unoesc.pessoaservice.model.Contato;
import br.edu.unoesc.pessoaservice.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoServiceImpl implements ContatoService{

    // == fields ==
    private ContatoRepository contatoRepository;

    // == constructors ==
    @Autowired
    public ContatoServiceImpl(ContatoRepository contatoRepository){
        this.contatoRepository = contatoRepository;
    }

    @Override
    public List<Contato> getAll() {
        return contatoRepository.findAll(Sort.by("id").ascending());
    }

    @Override
    public Optional<Contato> getOne(Long id) {
        return contatoRepository.findById(id);
    }

    @Override
    public Contato create(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public Contato update(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public void delete(Long id) {
        contatoRepository.deleteById(id);
    }
}
