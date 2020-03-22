package br.edu.unoesc.sistemautils.arquitetura.persistence;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDetailEntity;
import br.edu.unoesc.sistemautils.arquitetura.common.AbstractMasterEntity;

public interface IDetailRepository<EM extends AbstractMasterEntity, ED extends AbstractDetailEntity<EM>, ID extends Number> extends IRepository<ED, ID> {

}
