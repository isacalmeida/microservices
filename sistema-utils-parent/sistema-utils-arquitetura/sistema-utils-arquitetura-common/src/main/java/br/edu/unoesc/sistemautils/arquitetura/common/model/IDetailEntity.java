package br.edu.unoesc.sistemautils.arquitetura.common.model;

public interface IDetailEntity<EM extends AbstractMasterEntity> extends IIdentityEntity<Long> {

	EM getMasterEntity();
	
	void setMasterEntity(EM masterEntity);
}
