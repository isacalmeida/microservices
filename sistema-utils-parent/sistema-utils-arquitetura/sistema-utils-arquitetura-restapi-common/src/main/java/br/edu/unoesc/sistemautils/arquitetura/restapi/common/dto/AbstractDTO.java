package br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public abstract class AbstractDTO<DTO extends RepresentationModel<DTO>> extends RepresentationModel<DTO> implements IIdentityDTO, Serializable {

	private static final long serialVersionUID = 1L;
}
