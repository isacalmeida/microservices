package br.edu.unoesc.pessoaservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.business.common.service.TipoContatoService;
import br.edu.unoesc.pessoaservice.common.model.TipoContato;
import br.edu.unoesc.pessoaservice.restapi.common.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.common.dto.TipoContatoDTO;
import br.edu.unoesc.pessoaservice.restapi.converter.TipoContatoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;

@RestController
@RequestMapping(value = PessoaRestapiConstants.TIPO_CONTATO_V1)
public class TipoContatoRestController extends AbstractIdentityRestController<TipoContato, Long, TipoContatoDTO, TipoContatoService, TipoContatoDTOConverter> {

}
