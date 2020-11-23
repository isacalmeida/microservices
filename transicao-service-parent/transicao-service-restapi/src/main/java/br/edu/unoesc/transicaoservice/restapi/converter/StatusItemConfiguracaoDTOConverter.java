package br.edu.unoesc.transicaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.StatusItemConfiguracaoDTO;
import br.edu.unoesc.transicaoservice.common.model.StatusItemConfiguracao;

@Component
public class StatusItemConfiguracaoDTOConverter extends IdentityDTOConverter<StatusItemConfiguracao, Long, StatusItemConfiguracaoDTO> {

	public StatusItemConfiguracaoDTOConverter() {
		super(StatusItemConfiguracao.class, StatusItemConfiguracaoDTO.class);
	}
}
