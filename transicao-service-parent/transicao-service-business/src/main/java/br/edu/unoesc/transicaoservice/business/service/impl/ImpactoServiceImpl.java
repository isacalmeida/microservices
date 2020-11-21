package br.edu.unoesc.transicaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;
import br.edu.unoesc.transicaoservice.business.common.service.ImpactoService;
import br.edu.unoesc.transicaoservice.common.model.Impacto;
import br.edu.unoesc.transicaoservice.persistence.repository.ImpactoRepository;

@Service
public class ImpactoServiceImpl extends AbstractIdentityService<Impacto, Long, ImpactoRepository> implements ImpactoService {
}
