package br.edu.unoesc.sistemautils.arquitetura.common.model;

import java.io.Serializable;

public interface IIdentityEntity<ID extends Number> extends Serializable {

	ID getId();

	void setId(ID id);
}
