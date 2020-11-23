package br.edu.unoesc.transicaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DetailDTOConverter;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.MudancaItemConfiguracaoDTO;
import br.edu.unoesc.transicaoservice.common.model.Mudanca;
import br.edu.unoesc.transicaoservice.common.model.MudancaItemConfiguracao;

@Component
public class MudancaItemConfiguracaoDTOConverter extends DetailDTOConverter<Mudanca, MudancaItemConfiguracao, MudancaItemConfiguracaoDTO> {

	public MudancaItemConfiguracaoDTOConverter() {
		super(MudancaItemConfiguracao.class, MudancaItemConfiguracaoDTO.class);
	}
}
