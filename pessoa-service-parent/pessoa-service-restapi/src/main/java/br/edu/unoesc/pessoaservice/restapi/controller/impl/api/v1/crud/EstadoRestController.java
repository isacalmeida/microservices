package br.edu.unoesc.pessoaservice.restapi.controller.impl.api.v1.crud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.business.common.service.EstadoService;
import br.edu.unoesc.pessoaservice.common.model.Estado;
import br.edu.unoesc.pessoaservice.restapi.common.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.common.dto.EstadoDTO;
import br.edu.unoesc.pessoaservice.restapi.converter.EstadoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractRestController;

@RestController
@RequestMapping(PessoaRestapiConstants.ESTADO_V1)
public class EstadoRestController extends AbstractRestController<Estado, EstadoDTO, EstadoService, EstadoDTOConverter> {

}
