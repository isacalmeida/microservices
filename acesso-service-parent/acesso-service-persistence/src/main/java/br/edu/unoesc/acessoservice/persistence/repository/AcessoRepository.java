package br.edu.unoesc.acessoservice.persistence.repository;

import org.springframework.stereotype.Repository;

import br.edu.unoesc.acessoservice.common.model.Acesso;
import br.edu.unoesc.acessoservice.common.model.Perfil;
import br.edu.unoesc.sistemautils.arquitetura.persistence.repository.IDetailRepository;

@Repository
public interface AcessoRepository extends IDetailRepository<Perfil, Acesso, Long> {
}
