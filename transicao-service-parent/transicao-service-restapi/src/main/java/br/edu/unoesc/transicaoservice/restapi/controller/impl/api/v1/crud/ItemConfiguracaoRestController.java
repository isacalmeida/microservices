package br.edu.unoesc.transicaoservice.restapi.controller.impl.api.v1.crud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractRestController;
import br.edu.unoesc.transicaoservice.business.common.service.ItemConfiguracaoService;
import br.edu.unoesc.transicaoservice.common.model.ItemConfiguracao;
import br.edu.unoesc.transicaoservice.restapi.common.constants.TransicaoRestapiConstants;
import br.edu.unoesc.transicaoservice.restapi.common.dto.ItemConfiguracaoDTO;
import br.edu.unoesc.transicaoservice.restapi.converter.ItemConfiguracaoDTOConverter;

@RestController
@RequestMapping(value = TransicaoRestapiConstants.ITEM_CONFIGURACAO_V1)
public class ItemConfiguracaoRestController extends AbstractRestController<ItemConfiguracao, ItemConfiguracaoDTO, ItemConfiguracaoService, ItemConfiguracaoDTOConverter> {
}
