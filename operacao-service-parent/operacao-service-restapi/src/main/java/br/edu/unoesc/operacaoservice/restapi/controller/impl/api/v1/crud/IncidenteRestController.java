package br.edu.unoesc.operacaoservice.restapi.controller.impl.api.v1.crud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.operacaoservice.business.common.service.IncidenteService;
import br.edu.unoesc.operacaoservice.common.model.Incidente;
import br.edu.unoesc.operacaoservice.restapi.common.constants.OperacaoRestapiConstants;
import br.edu.unoesc.operacaoservice.restapi.common.dto.IncidenteDTO;
import br.edu.unoesc.operacaoservice.restapi.converter.IncidenteDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractRestController;

@RestController
@RequestMapping(value = OperacaoRestapiConstants.INCIDENTE_V1)
public class IncidenteRestController extends AbstractRestController<Incidente, IncidenteDTO, IncidenteService, IncidenteDTOConverter> {
}
