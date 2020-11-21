package br.edu.unoesc.operacaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.operacaoservice.business.common.service.StatusRequisicaoService;
import br.edu.unoesc.operacaoservice.common.model.StatusRequisicao;
import br.edu.unoesc.operacaoservice.persistence.repository.StatusRequisicaoRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;

@Service
public class StatusRequisicaoServiceImpl extends AbstractIdentityService<StatusRequisicao, Long, StatusRequisicaoRepository> implements StatusRequisicaoService {
}
