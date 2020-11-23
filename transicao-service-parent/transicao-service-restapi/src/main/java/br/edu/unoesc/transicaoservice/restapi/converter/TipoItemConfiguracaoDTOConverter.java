package br.edu.unoesc.transicaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.TipoItemConfiguracaoDTO;
import br.edu.unoesc.transicaoservice.common.model.TipoItemConfiguracao;

@Component
public class TipoItemConfiguracaoDTOConverter extends IdentityDTOConverter<TipoItemConfiguracao, Long, TipoItemConfiguracaoDTO> {

	public TipoItemConfiguracaoDTOConverter() {
		super(TipoItemConfiguracao.class, TipoItemConfiguracaoDTO.class);
	}
}
