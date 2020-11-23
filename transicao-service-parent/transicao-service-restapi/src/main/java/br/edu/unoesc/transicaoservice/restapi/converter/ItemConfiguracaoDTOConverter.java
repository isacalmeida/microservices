package br.edu.unoesc.transicaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DTOConverter;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.ItemConfiguracaoDTO;
import br.edu.unoesc.transicaoservice.common.model.ItemConfiguracao;

@Component
public class ItemConfiguracaoDTOConverter extends DTOConverter<ItemConfiguracao, ItemConfiguracaoDTO> {

	public ItemConfiguracaoDTOConverter() {
		super(ItemConfiguracao.class, ItemConfiguracaoDTO.class);
	}
}
