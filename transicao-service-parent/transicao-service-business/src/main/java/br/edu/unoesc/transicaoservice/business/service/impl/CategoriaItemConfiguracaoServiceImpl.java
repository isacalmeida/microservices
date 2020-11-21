package br.edu.unoesc.transicaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;
import br.edu.unoesc.transicaoservice.business.common.service.CategoriaItemConfiguracaoService;
import br.edu.unoesc.transicaoservice.common.model.CategoriaItemConfiguracao;
import br.edu.unoesc.transicaoservice.persistence.repository.CategoriaItemConfiguracaoRepository;

@Service
public class CategoriaItemConfiguracaoServiceImpl extends AbstractIdentityService<CategoriaItemConfiguracao, Long, CategoriaItemConfiguracaoRepository> implements CategoriaItemConfiguracaoService {
}
