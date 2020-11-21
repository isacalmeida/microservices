package br.edu.unoesc.transicaoservice.restapi.controller.impl.api.v1.crud.mudanca;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractDetailRestController;
import br.edu.unoesc.transicaoservice.business.common.service.MudancaItemConfiguracaoService;
import br.edu.unoesc.transicaoservice.common.model.Mudanca;
import br.edu.unoesc.transicaoservice.common.model.MudancaItemConfiguracao;
import br.edu.unoesc.transicaoservice.restapi.common.constants.TransicaoRestapiConstants;
import br.edu.unoesc.transicaoservice.restapi.common.dto.MudancaItemConfiguracaoDTO;
import br.edu.unoesc.transicaoservice.restapi.converter.MudancaItemConfiguracaoDTOConverter;

@RestController
@RequestMapping(value = TransicaoRestapiConstants.MUDANCA_ITEM_CONFIGURACAO_V1)
public class MudancaItemConfiguracaoRestController extends AbstractDetailRestController<Mudanca, MudancaItemConfiguracao, MudancaItemConfiguracaoDTO, MudancaItemConfiguracaoService, MudancaItemConfiguracaoDTOConverter> {
}
