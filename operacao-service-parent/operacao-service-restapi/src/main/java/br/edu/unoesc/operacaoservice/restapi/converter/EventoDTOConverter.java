package br.edu.unoesc.operacaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.operacaoservice.common.model.Evento;
import br.edu.unoesc.operacaoservice.restapi.common.dto.EventoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DTOConverter;

@Component
public class EventoDTOConverter extends DTOConverter<Evento, EventoDTO> {

	public EventoDTOConverter() {
		super(Evento.class, EventoDTO.class);
	}
}
