package br.edu.unoesc.pessoaservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.TipoEndereco;
import br.edu.unoesc.pessoaservice.restapi.common.dto.TipoEnderecoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;

@Component
public class TipoEnderecoDTOConverter extends IdentityDTOConverter<TipoEndereco, Long, TipoEnderecoDTO> {

	public TipoEnderecoDTOConverter() {
		super(TipoEndereco.class, TipoEnderecoDTO.class);
	}
}
