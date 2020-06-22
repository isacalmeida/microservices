package br.edu.unoesc.pessoaservice.restapi.resources.impl.api.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.pessoaservice.common.model.TipoDocumentoPessoa;
import br.edu.unoesc.pessoaservice.persistence.service.TipoDocumentoPessoaService;
import br.edu.unoesc.pessoaservice.restapi.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.converters.TipoDocumentoPessoaDTOConverter;
import br.edu.unoesc.pessoaservice.restapi.dto.TipoDocumentoPessoaDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.AbstractDetailRestController;

@RestController
@RequestMapping(value = PessoaRestapiConstants.PESSOA_DOCUMENTO_V1)
public class PessoaTipoDocumentoPessoaRestController extends AbstractDetailRestController<Pessoa, TipoDocumentoPessoa, TipoDocumentoPessoaDTO, TipoDocumentoPessoaService, TipoDocumentoPessoaDTOConverter> {

}
