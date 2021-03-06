package br.edu.unoesc.pessoaservice.business.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoaservice.business.common.service.CidadeService;
import br.edu.unoesc.pessoaservice.common.model.Cidade;
import br.edu.unoesc.pessoaservice.persistence.repository.CidadeRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractCrudService;

@Service
public class CidadeServiceImpl extends AbstractCrudService<Cidade, CidadeRepository> implements CidadeService {

    @Override
    public Cidade findOneCidadeBySiglaAndDescricao(String siglaEstado, String descricao) {
        return getRepository().findByEstado_SiglaAndDescricao(siglaEstado, descricao);
    }

	@Override
	public List<Cidade> getAllByEstado(Long idEstado) {
		return getRepository().findAllByEstado_IdEstado(idEstado);
	}
}
