package br.edu.unoesc.operacaoservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.operacaoservice.business.common.service.StatusProblemaService;
import br.edu.unoesc.operacaoservice.common.model.StatusProblema;
import br.edu.unoesc.operacaoservice.restapi.common.constants.OperacaoRestapiConstants;
import br.edu.unoesc.operacaoservice.restapi.common.dto.StatusProblemaDTO;
import br.edu.unoesc.operacaoservice.restapi.converter.StatusProblemaDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;

@RestController
@RequestMapping(value = OperacaoRestapiConstants.STATUS_PROBLEMA_V1)
public class StatusProblemaRestController extends AbstractIdentityRestController<StatusProblema, Long, StatusProblemaDTO, StatusProblemaService, StatusProblemaDTOConverter> {
}
