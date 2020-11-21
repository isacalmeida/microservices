package br.edu.unoesc.operacaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.operacaoservice.common.model.StatusEvento;
import br.edu.unoesc.operacaoservice.restapi.common.dto.StatusEventoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;

@Component
public class StatusEventoDTOConverter extends IdentityDTOConverter<StatusEvento, Long, StatusEventoDTO> {

	public StatusEventoDTOConverter() {
		super(StatusEvento.class, StatusEventoDTO.class);
	}
}
