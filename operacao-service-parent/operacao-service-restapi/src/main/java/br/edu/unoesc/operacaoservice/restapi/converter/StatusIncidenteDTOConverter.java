package br.edu.unoesc.operacaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.operacaoservice.common.model.StatusIncidente;
import br.edu.unoesc.operacaoservice.restapi.common.dto.StatusIncidenteDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;

@Component
public class StatusIncidenteDTOConverter extends IdentityDTOConverter<StatusIncidente, Long, StatusIncidenteDTO> {

	public StatusIncidenteDTOConverter() {
		super(StatusIncidente.class, StatusIncidenteDTO.class);
	}
}
