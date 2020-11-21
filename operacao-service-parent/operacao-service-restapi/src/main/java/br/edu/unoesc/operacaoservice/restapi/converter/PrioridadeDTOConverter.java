package br.edu.unoesc.operacaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.operacaoservice.common.model.Prioridade;
import br.edu.unoesc.operacaoservice.restapi.common.dto.PrioridadeDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;

@Component
public class PrioridadeDTOConverter extends IdentityDTOConverter<Prioridade, Long, PrioridadeDTO> {

	public PrioridadeDTOConverter() {
		super(Prioridade.class, PrioridadeDTO.class);
	}
}
