package br.edu.unoesc.operacaoservice.restapi.controller.impl.api.v1.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.operacaoservice.business.common.service.RequisicaoService;
import br.edu.unoesc.operacaoservice.common.model.Requisicao;
import br.edu.unoesc.operacaoservice.restapi.common.constants.OperacaoRestapiConstants;
import br.edu.unoesc.operacaoservice.restapi.common.dto.RequisicaoDTO;
import br.edu.unoesc.operacaoservice.restapi.converter.RequisicaoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractRestController;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.MudancaDTO;
import br.edu.unoesc.sistemautils.shared.restapi.zuul.ZuulClient;

@RestController
@RequestMapping(value = OperacaoRestapiConstants.REQUISICAO_V1)
public class RequisicaoRestController extends AbstractRestController<Requisicao, RequisicaoDTO, RequisicaoService, RequisicaoDTOConverter> {

	@Autowired
	private ZuulClient zuulClient;

	@Override
	public ResponseEntity<RequisicaoDTO> getOne(Long id) {
		ResponseEntity<RequisicaoDTO> responseEntity = super.getOne(id);
		if(responseEntity.hasBody()) {

			RequisicaoDTO requisicao = responseEntity.getBody();
			popularMudanca(requisicao);
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<RequisicaoDTO> update(Long id, RequisicaoDTO dto) {
		ResponseEntity<RequisicaoDTO> responseEntity = super.update(id, dto);
		if(responseEntity.hasBody()) {

			RequisicaoDTO requisicao = responseEntity.getBody();
			popularMudanca(requisicao);
		}
		return responseEntity;
	}

	private void popularMudanca(RequisicaoDTO requisicao) {
		Long idMudanca = requisicao.getProtocoloMudanca();
		MudancaDTO mudanca = zuulClient.getOneMudanca(idMudanca);
		requisicao.setMudanca(mudanca);
	}
}
