package br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface IIdentityDTO {

	@JsonIgnore
	Long getId();

	void setId(Long id);
}
