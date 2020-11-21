package br.edu.unoesc.acessoservice.business.service.impl;

import org.springframework.stereotype.Service;

import br.edu.unoesc.acessoservice.business.common.service.AcessoService;
import br.edu.unoesc.acessoservice.common.model.Acesso;
import br.edu.unoesc.acessoservice.common.model.Perfil;
import br.edu.unoesc.acessoservice.persistence.repository.AcessoRepository;
import br.edu.unoesc.acessoservice.persistence.repository.PerfilRepository;
import br.edu.unoesc.sistemautils.arquitetura.business.AbstractDetailCrudService;

@Service
public class AcessoServiceImpl extends AbstractDetailCrudService<Perfil, Acesso, PerfilRepository, AcessoRepository> implements AcessoService {
}
