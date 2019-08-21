package br.edu.unoesc.pessoaservice.service;

import br.edu.unoesc.pessoaservice.model.Pessoa;
import br.edu.unoesc.pessoaservice.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    // == fields ==
    private PessoaRepository pessoaRepository;

    // == constructors ==
    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public List<Pessoa> getAll() {
        return pessoaRepository.findAll(Sort.by("id").ascending());
    }

    @Override
    public Optional<Pessoa> getOne(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public Pessoa create(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }
}