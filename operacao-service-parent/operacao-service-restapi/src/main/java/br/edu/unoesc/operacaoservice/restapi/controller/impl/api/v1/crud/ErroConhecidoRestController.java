package br.edu.unoesc.operacaoservice.restapi.controller.impl.api.v1.crud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.operacaoservice.business.common.service.ErroConhecidoService;
import br.edu.unoesc.operacaoservice.common.model.ErroConhecido;
import br.edu.unoesc.operacaoservice.restapi.common.constants.OperacaoRestapiConstants;
import br.edu.unoesc.operacaoservice.restapi.common.dto.ErroConhecidoDTO;
import br.edu.unoesc.operacaoservice.restapi.converter.ErroConhecidoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractRestController;

@RestController
@RequestMapping(value = OperacaoRestapiConstants.ERRO_CONHECIDO_V1)
public class ErroConhecidoRestController extends AbstractRestController<ErroConhecido, ErroConhecidoDTO, ErroConhecidoService, ErroConhecidoDTOConverter> {
}
