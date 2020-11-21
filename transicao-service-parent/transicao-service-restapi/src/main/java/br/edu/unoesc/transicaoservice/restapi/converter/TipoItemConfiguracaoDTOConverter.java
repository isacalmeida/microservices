package br.edu.unoesc.transicaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;
import br.edu.unoesc.transicaoservice.common.model.TipoItemConfiguracao;
import br.edu.unoesc.transicaoservice.restapi.common.dto.TipoItemConfiguracaoDTO;

@Component
public class TipoItemConfiguracaoDTOConverter extends IdentityDTOConverter<TipoItemConfiguracao, Long, TipoItemConfiguracaoDTO> {

	public TipoItemConfiguracaoDTOConverter() {
		super(TipoItemConfiguracao.class, TipoItemConfiguracaoDTO.class);
	}
}
