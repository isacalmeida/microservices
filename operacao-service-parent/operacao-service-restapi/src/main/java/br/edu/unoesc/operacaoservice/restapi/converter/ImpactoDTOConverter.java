package br.edu.unoesc.operacaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.operacaoservice.common.model.Impacto;
import br.edu.unoesc.operacaoservice.restapi.common.dto.ImpactoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;

@Component
public class ImpactoDTOConverter extends IdentityDTOConverter<Impacto, Long, ImpactoDTO> {

	public ImpactoDTOConverter() {
		super(Impacto.class, ImpactoDTO.class);
	}
}
