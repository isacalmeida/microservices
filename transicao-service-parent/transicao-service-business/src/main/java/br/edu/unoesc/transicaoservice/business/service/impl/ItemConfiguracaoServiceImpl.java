package br.edu.unoesc.transicaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.sistemautils.arquitetura.business.AbstractCrudService;
import br.edu.unoesc.transicaoservice.business.common.service.ItemConfiguracaoService;
import br.edu.unoesc.transicaoservice.common.model.ItemConfiguracao;
import br.edu.unoesc.transicaoservice.persistence.repository.ItemConfiguracaoRepository;

@Service
public class ItemConfiguracaoServiceImpl extends AbstractCrudService<ItemConfiguracao, ItemConfiguracaoRepository> implements ItemConfiguracaoService {
}
