package br.edu.unoesc.operacaoservice.restapi.controller.impl.api.v1.crud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.operacaoservice.business.common.service.RequisicaoService;
import br.edu.unoesc.operacaoservice.common.model.Requisicao;
import br.edu.unoesc.operacaoservice.restapi.common.constants.OperacaoRestapiConstants;
import br.edu.unoesc.operacaoservice.restapi.common.dto.RequisicaoDTO;
import br.edu.unoesc.operacaoservice.restapi.converter.RequisicaoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractRestController;

@RestController
@RequestMapping(value = OperacaoRestapiConstants.REQUISICAO_V1)
public class RequisicaoRestController extends AbstractRestController<Requisicao, RequisicaoDTO, RequisicaoService, RequisicaoDTOConverter> {
}
