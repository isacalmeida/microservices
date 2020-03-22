package br.edu.unoesc.sistemautils.arquitetura.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface IIdentityEntity<ID extends Number> extends Serializable {

	@JsonIgnore
	ID getId();

	void setId(ID id);
}
