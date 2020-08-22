package br.edu.unoesc.pessoaservice.business.common.service;

import java.util.List;

import br.edu.unoesc.pessoaservice.common.model.Cep;
import br.edu.unoesc.sistemautils.arquitetura.business.common.ICrudService;

public interface CepService extends ICrudService<Cep> {

    List<Cep> getAllByEstadoAndCidade(Long idEstado, Long idCidade);

    List<Cep> getAllByCep(String cep);

    Cep getOneByCep(String cep);
}
