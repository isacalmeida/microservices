package br.edu.unoesc.pessoaservice.business.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoaservice.business.common.service.CepService;
import br.edu.unoesc.pessoaservice.common.model.Cep;
import br.edu.unoesc.pessoaservice.persistence.repository.CepRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractCrudService;

@Service
public class CepServiceImpl extends AbstractCrudService<Cep, CepRepository> implements CepService {

    @Override
    public List<Cep> getAllByEstadoAndCidade(Long idEstado, Long idCidade) {
        return getRepository().findAllByCidade_Estado_IdEstadoAndCidade_IdCidade(idEstado, idCidade);
    }

    @Override
    public List<Cep> getAllByCep(String cep){
        return getRepository().findAllByCepStartingWithOrderByCep(cep);
    }

	@Override
	public Cep getOneByCep(String cep) {
		return getRepository().findByCep(cep);
	}
}
