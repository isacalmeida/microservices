package br.edu.unoesc.operacaoservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.operacaoservice.business.common.service.StatusRequisicaoService;
import br.edu.unoesc.operacaoservice.common.model.StatusRequisicao;
import br.edu.unoesc.operacaoservice.restapi.common.constants.OperacaoRestapiConstants;
import br.edu.unoesc.operacaoservice.restapi.common.dto.StatusRequisicaoDTO;
import br.edu.unoesc.operacaoservice.restapi.converter.StatusRequisicaoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;

@RestController
@RequestMapping(value = OperacaoRestapiConstants.STATUS_REQUISICAO_V1)
public class StatusRequisicaoRestController extends AbstractIdentityRestController<StatusRequisicao, Long, StatusRequisicaoDTO, StatusRequisicaoService, StatusRequisicaoDTOConverter> {
}
