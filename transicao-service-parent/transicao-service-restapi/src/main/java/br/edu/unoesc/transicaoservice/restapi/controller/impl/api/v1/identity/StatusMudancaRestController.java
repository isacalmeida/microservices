package br.edu.unoesc.transicaoservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;
import br.edu.unoesc.transicaoservice.business.common.service.StatusMudancaService;
import br.edu.unoesc.transicaoservice.common.model.StatusMudanca;
import br.edu.unoesc.transicaoservice.restapi.common.constants.TransicaoRestapiConstants;
import br.edu.unoesc.transicaoservice.restapi.common.dto.StatusMudancaDTO;
import br.edu.unoesc.transicaoservice.restapi.converter.StatusMudancaDTOConverter;

@RestController
@RequestMapping(value = TransicaoRestapiConstants.STATUS_MUDANCA_V1)
public class StatusMudancaRestController extends AbstractIdentityRestController<StatusMudanca, Long, StatusMudancaDTO, StatusMudancaService, StatusMudancaDTOConverter> {
}
