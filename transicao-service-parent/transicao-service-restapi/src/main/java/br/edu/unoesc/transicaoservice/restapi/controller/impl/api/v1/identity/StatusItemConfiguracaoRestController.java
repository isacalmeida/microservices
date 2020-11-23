package br.edu.unoesc.transicaoservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.StatusItemConfiguracaoDTO;
import br.edu.unoesc.transicaoservice.business.common.service.StatusItemConfiguracaoService;
import br.edu.unoesc.transicaoservice.common.model.StatusItemConfiguracao;
import br.edu.unoesc.transicaoservice.restapi.common.constants.TransicaoRestapiConstants;
import br.edu.unoesc.transicaoservice.restapi.converter.StatusItemConfiguracaoDTOConverter;

@RestController
@RequestMapping(value = TransicaoRestapiConstants.STATUS_ITEM_CONFIGURACAO_V1)
public class StatusItemConfiguracaoRestController extends AbstractIdentityRestController<StatusItemConfiguracao, Long, StatusItemConfiguracaoDTO, StatusItemConfiguracaoService, StatusItemConfiguracaoDTOConverter> {
}
