package br.edu.unoesc.pessoaservice.service;

import br.edu.unoesc.pessoaservice.model.Cep;
import br.edu.unoesc.pessoaservice.repository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CepServiceImpl implements CepService{

    // == fields ==
    private CepRepository cepRepository;

    // == constructors ==
    @Autowired
    public CepServiceImpl(CepRepository cepRepository){
        this.cepRepository = cepRepository;
    }

    @Override
    public List<Cep> getAll() {
        return cepRepository.findAll(Sort.by("id").ascending());
    }

    @Override
    public List<Cep> getAllByEstadoAndCidade(Long idEstado, Long idCidade) {
        return cepRepository.findAllByCidade_Estado_IdAndCidade_Id(idEstado, idCidade);
    }

    @Override
    public Optional<Cep> getOne(Long id) {
        return cepRepository.findById(id);
    }

    @Override
    public Cep create(Cep cep) {
        return cepRepository.save(cep);
    }

    @Override
    public Cep update(Cep cep) {
        return cepRepository.save(cep);
    }

    @Override
    public void delete(Long id) {
        cepRepository.deleteById(id);
    }

}
