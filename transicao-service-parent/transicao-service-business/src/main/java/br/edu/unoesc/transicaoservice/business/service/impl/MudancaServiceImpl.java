package br.edu.unoesc.transicaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.sistemautils.arquitetura.business.AbstractMasterCrudService;
import br.edu.unoesc.transicaoservice.business.common.service.MudancaService;
import br.edu.unoesc.transicaoservice.common.model.Mudanca;
import br.edu.unoesc.transicaoservice.persistence.repository.MudancaRepository;

@Service
public class MudancaServiceImpl extends AbstractMasterCrudService<Mudanca, MudancaRepository> implements MudancaService {
}
