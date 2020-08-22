package br.edu.unoesc.sistemautils.arquitetura.common.model;

import java.io.Serializable;

public interface IDetailEntity<EM extends AbstractMasterEntity> extends Serializable, IIdentityEntity<Long> {

	EM getMasterEntity();
	
	void setMasterEntity(EM masterEntity);
}
