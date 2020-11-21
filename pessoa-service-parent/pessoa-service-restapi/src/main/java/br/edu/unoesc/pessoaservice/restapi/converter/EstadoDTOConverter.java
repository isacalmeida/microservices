package br.edu.unoesc.pessoaservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.Estado;
import br.edu.unoesc.pessoaservice.restapi.common.dto.EstadoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DTOConverter;

@Component
public class EstadoDTOConverter extends DTOConverter<Estado, EstadoDTO> {

	public EstadoDTOConverter() {
		super(Estado.class, EstadoDTO.class);
	}
}
