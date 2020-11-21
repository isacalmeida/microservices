package br.edu.unoesc.transicaoservice.restapi.controller.impl.api.v1.crud.mudanca;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractMasterRestController;
import br.edu.unoesc.transicaoservice.business.common.service.MudancaService;
import br.edu.unoesc.transicaoservice.common.model.Mudanca;
import br.edu.unoesc.transicaoservice.restapi.common.constants.TransicaoRestapiConstants;
import br.edu.unoesc.transicaoservice.restapi.common.dto.MudancaDTO;
import br.edu.unoesc.transicaoservice.restapi.converter.MudancaDTOConverter;

@RestController
@RequestMapping(value = TransicaoRestapiConstants.MUDANCA_V1)
public class MudancaRestController extends AbstractMasterRestController<Mudanca, MudancaDTO, MudancaService, MudancaDTOConverter> {
}
