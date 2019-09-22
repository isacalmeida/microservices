package br.edu.unoesc.pessoaservice.service;

import br.edu.unoesc.pessoaservice.model.Cidade;
import br.edu.unoesc.pessoaservice.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeServiceImpl implements CidadeService{

    // == fields ==
    private CidadeRepository cidadeRepository;

    // == constructors ==
    @Autowired
    public CidadeServiceImpl(CidadeRepository cidadeRepository){
        this.cidadeRepository = cidadeRepository;
    }

    @Override
    public List<Cidade> getAll() {
        return cidadeRepository.findAll(Sort.by("id").ascending());
    }

    @Override
    public List<Cidade> getAllByEstado(Long idEstado){
        return cidadeRepository.findAllByEstado_Id(idEstado);
    }

    @Override
    public Optional<Cidade> getOne(Long id) {
        return cidadeRepository.findById(id);
    }

    @Override
    public Cidade create(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    @Override
    public Cidade update(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    @Override
    public void delete(Long id) {
        cidadeRepository.deleteById(id);
    }

    @Override
    public List<Cidade> findAllCidadeBySiglaAndDescricao(String sigla, String descricao) {
        return cidadeRepository.findAllByEstado_SiglaAndDescricao(sigla, descricao);
    }
}
