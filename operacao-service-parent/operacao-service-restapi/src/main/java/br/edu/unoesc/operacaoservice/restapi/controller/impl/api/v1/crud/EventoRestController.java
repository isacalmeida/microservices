package br.edu.unoesc.operacaoservice.restapi.controller.impl.api.v1.crud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.operacaoservice.business.common.service.EventoService;
import br.edu.unoesc.operacaoservice.common.model.Evento;
import br.edu.unoesc.operacaoservice.restapi.common.constants.OperacaoRestapiConstants;
import br.edu.unoesc.operacaoservice.restapi.common.dto.EventoDTO;
import br.edu.unoesc.operacaoservice.restapi.converter.EventoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractRestController;

@RestController
@RequestMapping(value = OperacaoRestapiConstants.EVENTO_V1)
public class EventoRestController extends AbstractRestController<Evento, EventoDTO, EventoService, EventoDTOConverter> {
}
