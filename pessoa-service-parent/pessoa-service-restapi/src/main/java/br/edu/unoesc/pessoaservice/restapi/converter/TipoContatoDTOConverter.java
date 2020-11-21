package br.edu.unoesc.pessoaservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.TipoContato;
import br.edu.unoesc.pessoaservice.restapi.common.dto.TipoContatoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;

@Component
public class TipoContatoDTOConverter extends IdentityDTOConverter<TipoContato, Long, TipoContatoDTO> {

	public TipoContatoDTOConverter() {
		super(TipoContato.class, TipoContatoDTO.class);
	}
}
