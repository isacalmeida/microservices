package br.edu.unoesc.operacaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.operacaoservice.common.model.Incidente;
import br.edu.unoesc.operacaoservice.restapi.common.dto.IncidenteDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DTOConverter;

@Component
public class IncidenteDTOConverter extends DTOConverter<Incidente, IncidenteDTO> {

	public IncidenteDTOConverter() {
		super(Incidente.class, IncidenteDTO.class);
	}
}
