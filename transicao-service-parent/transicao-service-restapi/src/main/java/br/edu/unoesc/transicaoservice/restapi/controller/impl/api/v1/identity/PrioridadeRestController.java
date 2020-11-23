package br.edu.unoesc.transicaoservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.PrioridadeDTO;
import br.edu.unoesc.transicaoservice.business.common.service.PrioridadeService;
import br.edu.unoesc.transicaoservice.common.model.Prioridade;
import br.edu.unoesc.transicaoservice.restapi.common.constants.TransicaoRestapiConstants;
import br.edu.unoesc.transicaoservice.restapi.converter.PrioridadeDTOConverter;

@RestController
@RequestMapping(value = TransicaoRestapiConstants.PRIORIDADE_V1)
public class PrioridadeRestController extends AbstractIdentityRestController<Prioridade, Long, PrioridadeDTO, PrioridadeService, PrioridadeDTOConverter> {
}
