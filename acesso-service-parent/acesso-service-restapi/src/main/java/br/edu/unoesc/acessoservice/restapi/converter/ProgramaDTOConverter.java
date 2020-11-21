package br.edu.unoesc.acessoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.acessoservice.common.model.Programa;
import br.edu.unoesc.acessoservice.restapi.common.dto.ProgramaDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DTOConverter;

@Component
public class ProgramaDTOConverter extends DTOConverter<Programa, ProgramaDTO> {

	public ProgramaDTOConverter() {
		super(Programa.class, ProgramaDTO.class);
	}
}
