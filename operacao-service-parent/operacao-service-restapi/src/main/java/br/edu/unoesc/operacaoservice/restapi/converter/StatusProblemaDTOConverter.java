package br.edu.unoesc.operacaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.operacaoservice.common.model.StatusProblema;
import br.edu.unoesc.operacaoservice.restapi.common.dto.StatusProblemaDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;

@Component
public class StatusProblemaDTOConverter extends IdentityDTOConverter<StatusProblema, Long, StatusProblemaDTO> {

	public StatusProblemaDTOConverter() {
		super(StatusProblema.class, StatusProblemaDTO.class);
	}
}
