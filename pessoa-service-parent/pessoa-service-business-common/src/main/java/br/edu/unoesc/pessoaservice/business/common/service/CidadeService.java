package br.edu.unoesc.pessoaservice.business.common.service;

import java.util.List;

import br.edu.unoesc.pessoaservice.common.model.Cidade;
import br.edu.unoesc.sistemautils.arquitetura.business.ICrudService;

public interface CidadeService extends ICrudService<Cidade> {

    List<Cidade> findAllCidadeBySiglaAndDescricao(String sigla, String descricao);

	List<Cidade> getAllByEstado(Long idEstado);
}
