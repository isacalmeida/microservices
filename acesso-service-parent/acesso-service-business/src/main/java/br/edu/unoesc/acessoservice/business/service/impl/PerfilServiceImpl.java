package br.edu.unoesc.acessoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.acessoservice.business.common.service.PerfilService;
import br.edu.unoesc.acessoservice.common.model.Perfil;
import br.edu.unoesc.acessoservice.persistence.repository.PerfilRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractMasterCrudService;

@Service
public class PerfilServiceImpl extends AbstractMasterCrudService<Perfil, PerfilRepository> implements PerfilService {
}
