package br.edu.unoesc.pessoaservice.persistence.service.impl.cep;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoaservice.api.service.cep.CepService;
import br.edu.unoesc.pessoaservice.common.model.cep.Cep;
import br.edu.unoesc.pessoaservice.persistence.repository.cep.CepRepository;

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
    public List<Cep> getAllByCep(String cep){
        return cepRepository.findAllByCepStartingWithOrderByCep(cep);
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
