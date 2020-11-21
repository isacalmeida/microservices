package br.edu.unoesc.operacaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.operacaoservice.common.model.Problema;
import br.edu.unoesc.operacaoservice.restapi.common.dto.ProblemaDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DTOConverter;

@Component
public class ProblemaDTOConverter extends DTOConverter<Problema, ProblemaDTO> {

	public ProblemaDTOConverter() {
		super(Problema.class, ProblemaDTO.class);
	}
}
