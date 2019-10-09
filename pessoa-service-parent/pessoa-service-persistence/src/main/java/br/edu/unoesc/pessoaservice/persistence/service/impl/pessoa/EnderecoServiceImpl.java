package br.edu.unoesc.pessoaservice.persistence.service.impl.pessoa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoaservice.api.service.pessoa.EnderecoService;
import br.edu.unoesc.pessoaservice.common.model.pessoa.Endereco;
import br.edu.unoesc.pessoaservice.persistence.repository.pessoa.EnderecoRepository;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    // == fields ==
    private EnderecoRepository enderecoRepository;

    // == constructors ==
    @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public List<Endereco> getAll() {
        return enderecoRepository.findAll(Sort.by("id").ascending());
    }

    @Override
    public Optional<Endereco> getOne(Long id) {
        return enderecoRepository.findById(id);
    }

    @Override
    public Endereco create(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco update(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public void delete(Long id) {
        enderecoRepository.deleteById(id);
    }
}
