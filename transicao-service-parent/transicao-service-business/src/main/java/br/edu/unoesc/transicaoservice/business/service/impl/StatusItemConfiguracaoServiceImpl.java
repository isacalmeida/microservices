package br.edu.unoesc.transicaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;
import br.edu.unoesc.transicaoservice.business.common.service.StatusItemConfiguracaoService;
import br.edu.unoesc.transicaoservice.common.model.StatusItemConfiguracao;
import br.edu.unoesc.transicaoservice.persistence.repository.StatusItemConfiguracaoRepository;

@Service
public class StatusItemConfiguracaoServiceImpl extends AbstractIdentityService<StatusItemConfiguracao, Long, StatusItemConfiguracaoRepository> implements StatusItemConfiguracaoService {
}
