package br.edu.unoesc.transicaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.CategoriaItemConfiguracaoDTO;
import br.edu.unoesc.transicaoservice.common.model.CategoriaItemConfiguracao;

@Component
public class CategoriaItemConfiguracaoDTOConverter extends IdentityDTOConverter<CategoriaItemConfiguracao, Long, CategoriaItemConfiguracaoDTO> {

	public CategoriaItemConfiguracaoDTOConverter() {
		super(CategoriaItemConfiguracao.class, CategoriaItemConfiguracaoDTO.class);
	}
}
