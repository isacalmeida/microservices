package br.edu.unoesc.operacaoservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.operacaoservice.business.common.service.ImpactoService;
import br.edu.unoesc.operacaoservice.common.model.Impacto;
import br.edu.unoesc.operacaoservice.restapi.common.constants.OperacaoRestapiConstants;
import br.edu.unoesc.operacaoservice.restapi.common.dto.ImpactoDTO;
import br.edu.unoesc.operacaoservice.restapi.converter.ImpactoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;

@RestController
@RequestMapping(value = OperacaoRestapiConstants.IMPACTO_V1)
public class ImpactoRestController extends AbstractIdentityRestController<Impacto, Long, ImpactoDTO, ImpactoService, ImpactoDTOConverter> {
}
