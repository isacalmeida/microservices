package br.edu.unoesc.operacaoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.operacaoservice.business.common.service.ImpactoService;
import br.edu.unoesc.operacaoservice.common.model.Impacto;
import br.edu.unoesc.operacaoservice.persistence.repository.ImpactoRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractIdentityService;

@Service
public class ImpactoServiceImpl extends AbstractIdentityService<Impacto, Long, ImpactoRepository> implements ImpactoService {
}
