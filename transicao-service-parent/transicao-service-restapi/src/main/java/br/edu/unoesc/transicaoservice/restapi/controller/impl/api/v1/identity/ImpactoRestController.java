package br.edu.unoesc.transicaoservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.ImpactoDTO;
import br.edu.unoesc.transicaoservice.business.common.service.ImpactoService;
import br.edu.unoesc.transicaoservice.common.model.Impacto;
import br.edu.unoesc.transicaoservice.restapi.common.constants.TransicaoRestapiConstants;
import br.edu.unoesc.transicaoservice.restapi.converter.ImpactoDTOConverter;

@RestController
@RequestMapping(value = TransicaoRestapiConstants.IMPACTO_V1)
public class ImpactoRestController extends AbstractIdentityRestController<Impacto, Long, ImpactoDTO, ImpactoService, ImpactoDTOConverter> {
}
