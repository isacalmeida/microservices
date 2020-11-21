package br.edu.unoesc.acessoservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.acessoservice.business.common.service.TipoServicoService;
import br.edu.unoesc.acessoservice.common.model.TipoServico;
import br.edu.unoesc.acessoservice.restapi.common.constants.AcessoRestapiConstants;
import br.edu.unoesc.acessoservice.restapi.common.dto.TipoServicoDTO;
import br.edu.unoesc.acessoservice.restapi.converter.TipoServicoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;

@RestController
@RequestMapping(AcessoRestapiConstants.TIPO_SERVICO_V1)
public class TipoServicoRestController extends AbstractIdentityRestController<TipoServico, Long, TipoServicoDTO, TipoServicoService, TipoServicoDTOConverter> {
}
