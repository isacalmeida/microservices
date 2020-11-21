package br.edu.unoesc.operacaoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.operacaoservice.common.model.StatusRequisicao;
import br.edu.unoesc.operacaoservice.restapi.common.dto.StatusRequisicaoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;

@Component
public class StatusRequisicaoDTOConverter extends IdentityDTOConverter<StatusRequisicao, Long, StatusRequisicaoDTO> {

	public StatusRequisicaoDTOConverter() {
		super(StatusRequisicao.class, StatusRequisicaoDTO.class);
	}
}
