package br.edu.unoesc.operacaoservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.operacaoservice.business.common.service.StatusIncidenteService;
import br.edu.unoesc.operacaoservice.common.model.StatusIncidente;
import br.edu.unoesc.operacaoservice.restapi.common.constants.OperacaoRestapiConstants;
import br.edu.unoesc.operacaoservice.restapi.common.dto.StatusIncidenteDTO;
import br.edu.unoesc.operacaoservice.restapi.converter.StatusIncidenteDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;

@RestController
@RequestMapping(value = OperacaoRestapiConstants.STATUS_INCIDENTE_V1)
public class StatusIncidenteRestController extends AbstractIdentityRestController<StatusIncidente, Long, StatusIncidenteDTO, StatusIncidenteService, StatusIncidenteDTOConverter> {
}
