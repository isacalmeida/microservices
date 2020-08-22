package br.edu.unoesc.pessoaservice.restapi.controller.impl.api.v1.crud.pessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.business.common.service.TipoDocumentoPessoaService;
import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.pessoaservice.common.model.TipoDocumentoPessoa;
import br.edu.unoesc.pessoaservice.restapi.common.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.common.dto.TipoDocumentoPessoaDTO;
import br.edu.unoesc.pessoaservice.restapi.converter.TipoDocumentoPessoaDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractDetailRestController;

@RestController
@RequestMapping(value = PessoaRestapiConstants.PESSOA_DOCUMENTO_V1)
public class PessoaTipoDocumentoPessoaRestController extends AbstractDetailRestController<Pessoa, TipoDocumentoPessoa, TipoDocumentoPessoaDTO, TipoDocumentoPessoaService, TipoDocumentoPessoaDTOConverter> {

}
