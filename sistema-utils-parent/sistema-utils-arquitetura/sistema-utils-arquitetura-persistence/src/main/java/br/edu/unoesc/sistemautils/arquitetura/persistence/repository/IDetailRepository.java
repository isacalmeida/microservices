package br.edu.unoesc.sistemautils.arquitetura.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractDetailEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractMasterEntity;

public interface IDetailRepository<EM extends AbstractMasterEntity, ED extends AbstractDetailEntity<EM>, ID extends Number> extends JpaRepository<ED, ID> {

}
