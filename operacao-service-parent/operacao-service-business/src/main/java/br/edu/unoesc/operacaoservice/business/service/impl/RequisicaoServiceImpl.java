package br.edu.unoesc.operacaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.operacaoservice.business.common.service.RequisicaoService;
import br.edu.unoesc.operacaoservice.common.model.Requisicao;
import br.edu.unoesc.operacaoservice.persistence.repository.RequisicaoRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractCrudService;

@Service
public class RequisicaoServiceImpl extends AbstractCrudService<Requisicao, RequisicaoRepository> implements RequisicaoService {
}
