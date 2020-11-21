package br.edu.unoesc.transicaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;
import br.edu.unoesc.transicaoservice.common.model.StatusMudanca;
import br.edu.unoesc.transicaoservice.restapi.common.dto.StatusMudancaDTO;

@Component
public class StatusMudancaDTOConverter extends IdentityDTOConverter<StatusMudanca, Long, StatusMudancaDTO> {

	public StatusMudancaDTOConverter() {
		super(StatusMudanca.class, StatusMudancaDTO.class);
	}
}
