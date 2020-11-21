package br.edu.unoesc.acessoservice.restapi.controller.impl.api.v1.crud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.acessoservice.business.common.service.ProgramaService;
import br.edu.unoesc.acessoservice.common.model.Programa;
import br.edu.unoesc.acessoservice.restapi.common.constants.AcessoRestapiConstants;
import br.edu.unoesc.acessoservice.restapi.common.dto.ProgramaDTO;
import br.edu.unoesc.acessoservice.restapi.converter.ProgramaDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractRestController;

@RestController
@RequestMapping(AcessoRestapiConstants.PROGRAMA_V1)
public class ProgramaRestController extends AbstractRestController<Programa, ProgramaDTO, ProgramaService, ProgramaDTOConverter> {
}
