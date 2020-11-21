package br.edu.unoesc.transicaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.sistemautils.arquitetura.business.AbstractDetailCrudService;
import br.edu.unoesc.transicaoservice.business.common.service.MudancaItemConfiguracaoService;
import br.edu.unoesc.transicaoservice.common.model.Mudanca;
import br.edu.unoesc.transicaoservice.common.model.MudancaItemConfiguracao;
import br.edu.unoesc.transicaoservice.persistence.repository.MudancaItemConfiguracaoRepository;
import br.edu.unoesc.transicaoservice.persistence.repository.MudancaRepository;

@Service
public class MudancaItemConfiguracaoServiceImpl extends AbstractDetailCrudService<Mudanca, MudancaItemConfiguracao, MudancaRepository, MudancaItemConfiguracaoRepository> implements MudancaItemConfiguracaoService {
}
