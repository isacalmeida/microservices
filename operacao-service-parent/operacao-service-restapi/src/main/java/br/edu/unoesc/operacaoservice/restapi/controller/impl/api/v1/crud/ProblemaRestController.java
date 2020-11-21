package br.edu.unoesc.operacaoservice.restapi.controller.impl.api.v1.crud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.operacaoservice.business.common.service.ProblemaService;
import br.edu.unoesc.operacaoservice.common.model.Problema;
import br.edu.unoesc.operacaoservice.restapi.common.constants.OperacaoRestapiConstants;
import br.edu.unoesc.operacaoservice.restapi.common.dto.ProblemaDTO;
import br.edu.unoesc.operacaoservice.restapi.converter.ProblemaDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractRestController;

@RestController
@RequestMapping(value = OperacaoRestapiConstants.PROBLEMA_V1)
public class ProblemaRestController extends AbstractRestController<Problema, ProblemaDTO, ProblemaService, ProblemaDTOConverter> {
}
