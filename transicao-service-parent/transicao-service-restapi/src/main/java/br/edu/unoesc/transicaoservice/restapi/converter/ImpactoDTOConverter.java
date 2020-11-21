package br.edu.unoesc.transicaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;
import br.edu.unoesc.transicaoservice.common.model.Impacto;
import br.edu.unoesc.transicaoservice.restapi.common.dto.ImpactoDTO;

@Component
public class ImpactoDTOConverter extends IdentityDTOConverter<Impacto, Long, ImpactoDTO> {

	public ImpactoDTOConverter() {
		super(Impacto.class, ImpactoDTO.class);
	}
}
