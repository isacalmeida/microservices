package br.edu.unoesc.acessoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.acessoservice.business.common.service.TipoServicoService;
import br.edu.unoesc.acessoservice.common.model.TipoServico;
import br.edu.unoesc.acessoservice.persistence.repository.TipoServicoRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;

@Service
public class TipoServicoServiceImpl extends AbstractIdentityService<TipoServico, Long, TipoServicoRepository> implements TipoServicoService {
}
