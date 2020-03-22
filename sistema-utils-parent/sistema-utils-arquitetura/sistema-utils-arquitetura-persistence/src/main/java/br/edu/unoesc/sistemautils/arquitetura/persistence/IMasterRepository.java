package br.edu.unoesc.sistemautils.arquitetura.persistence;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractMasterEntity;

public interface IMasterRepository<EM extends AbstractMasterEntity, ID extends Number> extends IRepository<EM, ID> {

}
