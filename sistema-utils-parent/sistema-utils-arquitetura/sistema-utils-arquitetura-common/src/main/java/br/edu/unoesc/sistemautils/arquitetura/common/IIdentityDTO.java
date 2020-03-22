package br.edu.unoesc.sistemautils.arquitetura.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface IIdentityDTO {

	@JsonIgnore
	Long getId();

	void setId(Long id);
}
