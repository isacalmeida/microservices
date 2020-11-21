package br.edu.unoesc.acessoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.acessoservice.common.model.TipoServico;
import br.edu.unoesc.acessoservice.restapi.common.dto.TipoServicoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;

@Component
public class TipoServicoDTOConverter extends IdentityDTOConverter<TipoServico, Long, TipoServicoDTO> {

	public TipoServicoDTOConverter() {
		super(TipoServico.class, TipoServicoDTO.class);
	}
}
