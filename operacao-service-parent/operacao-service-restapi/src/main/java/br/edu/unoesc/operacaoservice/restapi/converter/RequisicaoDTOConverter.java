package br.edu.unoesc.operacaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.operacaoservice.common.model.Requisicao;
import br.edu.unoesc.operacaoservice.restapi.common.dto.RequisicaoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DTOConverter;

@Component
public class RequisicaoDTOConverter extends DTOConverter<Requisicao, RequisicaoDTO> {

	public RequisicaoDTOConverter() {
		super(Requisicao.class, RequisicaoDTO.class);
	}
}
