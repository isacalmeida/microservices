package br.edu.unoesc.transicaoservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;
import br.edu.unoesc.transicaoservice.business.common.service.TipoItemConfiguracaoService;
import br.edu.unoesc.transicaoservice.common.model.TipoItemConfiguracao;
import br.edu.unoesc.transicaoservice.restapi.common.constants.TransicaoRestapiConstants;
import br.edu.unoesc.transicaoservice.restapi.common.dto.TipoItemConfiguracaoDTO;
import br.edu.unoesc.transicaoservice.restapi.converter.TipoItemConfiguracaoDTOConverter;

@RestController
@RequestMapping(value = TransicaoRestapiConstants.TIPO_ITEM_CONFIGURACAO_V1)
public class TipoItemConfiguracaoRestController extends AbstractIdentityRestController<TipoItemConfiguracao, Long, TipoItemConfiguracaoDTO, TipoItemConfiguracaoService, TipoItemConfiguracaoDTOConverter> {
}
