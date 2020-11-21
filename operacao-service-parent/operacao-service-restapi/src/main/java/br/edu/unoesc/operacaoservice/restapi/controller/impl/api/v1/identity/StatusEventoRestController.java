package br.edu.unoesc.operacaoservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.operacaoservice.business.common.service.StatusEventoService;
import br.edu.unoesc.operacaoservice.common.model.StatusEvento;
import br.edu.unoesc.operacaoservice.restapi.common.constants.OperacaoRestapiConstants;
import br.edu.unoesc.operacaoservice.restapi.common.dto.StatusEventoDTO;
import br.edu.unoesc.operacaoservice.restapi.converter.StatusEventoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;

@RestController
@RequestMapping(value = OperacaoRestapiConstants.STATUS_EVENTO_V1)
public class StatusEventoRestController extends AbstractIdentityRestController<StatusEvento, Long, StatusEventoDTO, StatusEventoService, StatusEventoDTOConverter> {
}
