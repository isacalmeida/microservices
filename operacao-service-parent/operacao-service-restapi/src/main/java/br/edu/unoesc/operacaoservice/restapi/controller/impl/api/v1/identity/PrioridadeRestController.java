package br.edu.unoesc.operacaoservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.operacaoservice.business.common.service.PrioridadeService;
import br.edu.unoesc.operacaoservice.common.model.Prioridade;
import br.edu.unoesc.operacaoservice.restapi.common.constants.OperacaoRestapiConstants;
import br.edu.unoesc.operacaoservice.restapi.common.dto.PrioridadeDTO;
import br.edu.unoesc.operacaoservice.restapi.converter.PrioridadeDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;

@RestController
@RequestMapping(value = OperacaoRestapiConstants.PRIORIDADE_V1)
public class PrioridadeRestController extends AbstractIdentityRestController<Prioridade, Long, PrioridadeDTO, PrioridadeService, PrioridadeDTOConverter> {
}
