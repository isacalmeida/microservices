package br.edu.unoesc.operacaoservice.restapi.controller.impl.api.v1.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.operacaoservice.business.common.service.EventoService;
import br.edu.unoesc.operacaoservice.common.model.Evento;
import br.edu.unoesc.operacaoservice.restapi.common.constants.OperacaoRestapiConstants;
import br.edu.unoesc.operacaoservice.restapi.common.dto.EventoDTO;
import br.edu.unoesc.operacaoservice.restapi.converter.EventoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractRestController;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.MudancaDTO;
import br.edu.unoesc.sistemautils.shared.restapi.zuul.ZuulClient;

@RestController
@RequestMapping(value = OperacaoRestapiConstants.EVENTO_V1)
public class EventoRestController extends AbstractRestController<Evento, EventoDTO, EventoService, EventoDTOConverter> {

	@Autowired
	private ZuulClient zuulClient;

	@Override
	public ResponseEntity<EventoDTO> getOne(Long id) {
		ResponseEntity<EventoDTO> responseEntity = super.getOne(id);
		if(responseEntity.hasBody()) {

			EventoDTO evento = responseEntity.getBody();
			popularMudanca(evento);
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<EventoDTO> update(Long id, EventoDTO dto) {
		ResponseEntity<EventoDTO> responseEntity = super.update(id, dto);
		if(responseEntity.hasBody()) {

			EventoDTO evento = responseEntity.getBody();
			popularMudanca(evento);
		}
		return responseEntity;
	}

	private void popularMudanca(EventoDTO evento) {
		Long idMudanca = evento.getProtocoloMudanca();
		MudancaDTO mudanca = zuulClient.getOneMudanca(idMudanca);
		evento.setMudanca(mudanca);
	}
}
