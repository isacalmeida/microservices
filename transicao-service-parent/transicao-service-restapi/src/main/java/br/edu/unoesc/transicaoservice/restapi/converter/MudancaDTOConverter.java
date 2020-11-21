package br.edu.unoesc.transicaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.MasterDTOConverter;
import br.edu.unoesc.transicaoservice.common.model.Mudanca;
import br.edu.unoesc.transicaoservice.restapi.common.dto.MudancaDTO;

@Component
public class MudancaDTOConverter extends MasterDTOConverter<Mudanca, MudancaDTO> {

	public MudancaDTOConverter() {
		super(Mudanca.class, MudancaDTO.class);
	}
}
