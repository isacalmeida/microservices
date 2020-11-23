package br.edu.unoesc.transicaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.StatusMudancaDTO;
import br.edu.unoesc.transicaoservice.common.model.StatusMudanca;

@Component
public class StatusMudancaDTOConverter extends IdentityDTOConverter<StatusMudanca, Long, StatusMudancaDTO> {

	public StatusMudancaDTOConverter() {
		super(StatusMudanca.class, StatusMudancaDTO.class);
	}
}
