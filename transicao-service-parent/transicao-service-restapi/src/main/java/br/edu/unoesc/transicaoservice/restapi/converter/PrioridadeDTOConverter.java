package br.edu.unoesc.transicaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.PrioridadeDTO;
import br.edu.unoesc.transicaoservice.common.model.Prioridade;

@Component
public class PrioridadeDTOConverter extends IdentityDTOConverter<Prioridade, Long, PrioridadeDTO> {

	public PrioridadeDTOConverter() {
		super(Prioridade.class, PrioridadeDTO.class);
	}
}
