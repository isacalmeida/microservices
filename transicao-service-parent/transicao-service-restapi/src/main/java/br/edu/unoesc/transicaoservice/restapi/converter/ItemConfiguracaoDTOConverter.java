package br.edu.unoesc.transicaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DTOConverter;
import br.edu.unoesc.transicaoservice.common.model.ItemConfiguracao;
import br.edu.unoesc.transicaoservice.restapi.common.dto.ItemConfiguracaoDTO;

@Component
public class ItemConfiguracaoDTOConverter extends DTOConverter<ItemConfiguracao, ItemConfiguracaoDTO> {

	public ItemConfiguracaoDTOConverter() {
		super(ItemConfiguracao.class, ItemConfiguracaoDTO.class);
	}
}
