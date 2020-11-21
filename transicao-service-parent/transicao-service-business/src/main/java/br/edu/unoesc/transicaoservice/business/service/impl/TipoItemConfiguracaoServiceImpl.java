package br.edu.unoesc.transicaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;
import br.edu.unoesc.transicaoservice.business.common.service.TipoItemConfiguracaoService;
import br.edu.unoesc.transicaoservice.common.model.TipoItemConfiguracao;
import br.edu.unoesc.transicaoservice.persistence.repository.TipoItemConfiguracaoRepository;

@Service
public class TipoItemConfiguracaoServiceImpl extends AbstractIdentityService<TipoItemConfiguracao, Long, TipoItemConfiguracaoRepository> implements TipoItemConfiguracaoService {
}
