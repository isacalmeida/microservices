package br.edu.unoesc.pessoaservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.business.common.service.TipoPessoaService;
import br.edu.unoesc.pessoaservice.common.model.TipoPessoa;
import br.edu.unoesc.pessoaservice.restapi.common.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.common.dto.TipoPessoaDTO;
import br.edu.unoesc.pessoaservice.restapi.converter.TipoPessoaDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;

@RestController
@RequestMapping(value = PessoaRestapiConstants.TIPO_PESSOA_V1)
public class TipoPessoaRestController extends AbstractIdentityRestController<TipoPessoa, Long, TipoPessoaDTO, TipoPessoaService, TipoPessoaDTOConverter> {

}
