package br.edu.unoesc.sistemautils.arquitetura.common.model;

public abstract class AbstractDetailEntity<EM extends AbstractMasterEntity> extends PersistableEntity implements IDetailEntity<EM> {

	private static final long serialVersionUID = 1L;
}
