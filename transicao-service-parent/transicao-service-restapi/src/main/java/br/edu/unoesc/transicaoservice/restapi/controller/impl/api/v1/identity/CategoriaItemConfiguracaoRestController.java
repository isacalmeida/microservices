package br.edu.unoesc.transicaoservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.CategoriaItemConfiguracaoDTO;
import br.edu.unoesc.transicaoservice.business.common.service.CategoriaItemConfiguracaoService;
import br.edu.unoesc.transicaoservice.common.model.CategoriaItemConfiguracao;
import br.edu.unoesc.transicaoservice.restapi.common.constants.TransicaoRestapiConstants;
import br.edu.unoesc.transicaoservice.restapi.converter.CategoriaItemConfiguracaoDTOConverter;

@RestController
@RequestMapping(value = TransicaoRestapiConstants.CATEGORIA_ITEM_CONFIGURACAO_V1)
public class CategoriaItemConfiguracaoRestController extends AbstractIdentityRestController<CategoriaItemConfiguracao, Long, CategoriaItemConfiguracaoDTO, CategoriaItemConfiguracaoService, CategoriaItemConfiguracaoDTOConverter> {
}
