package br.edu.unoesc.sistemautils.arquitetura.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.sistemautils.arquitetura.common.model.IIdentityEntity;

public interface IIdentityRepository<E extends IIdentityEntity<ID>, ID extends Number> extends JpaRepository<E, ID> {

}
