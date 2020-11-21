package br.edu.unoesc.pessoaservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.business.common.service.GeneroPessoaService;
import br.edu.unoesc.pessoaservice.common.model.GeneroPessoa;
import br.edu.unoesc.pessoaservice.restapi.common.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.common.dto.GeneroPessoaDTO;
import br.edu.unoesc.pessoaservice.restapi.converter.GeneroPessoaDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;

@RestController
@RequestMapping(value = PessoaRestapiConstants.GENERO_PESSOA_V1)
public class GeneroPessoaRestController extends AbstractIdentityRestController<GeneroPessoa, Long, GeneroPessoaDTO, GeneroPessoaService, GeneroPessoaDTOConverter> {

}
