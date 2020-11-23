package br.edu.unoesc.transicaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.ImpactoDTO;
import br.edu.unoesc.transicaoservice.common.model.Impacto;

@Component
public class ImpactoDTOConverter extends IdentityDTOConverter<Impacto, Long, ImpactoDTO> {

	public ImpactoDTOConverter() {
		super(Impacto.class, ImpactoDTO.class);
	}
}
