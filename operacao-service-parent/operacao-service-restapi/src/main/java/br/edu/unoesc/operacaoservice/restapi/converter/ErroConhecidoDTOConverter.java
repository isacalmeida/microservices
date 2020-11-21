package br.edu.unoesc.operacaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.operacaoservice.common.model.ErroConhecido;
import br.edu.unoesc.operacaoservice.restapi.common.dto.ErroConhecidoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DTOConverter;

@Component
public class ErroConhecidoDTOConverter extends DTOConverter<ErroConhecido, ErroConhecidoDTO> {

	public ErroConhecidoDTOConverter() {
		super(ErroConhecido.class, ErroConhecidoDTO.class);
	}
}
