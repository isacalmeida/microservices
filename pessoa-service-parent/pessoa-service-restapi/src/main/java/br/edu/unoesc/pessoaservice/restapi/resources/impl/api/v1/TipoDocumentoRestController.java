package br.edu.unoesc.pessoaservice.restapi.resources.impl.api.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.common.model.TipoDocumento;
import br.edu.unoesc.pessoaservice.persistence.service.TipoDocumentoService;
import br.edu.unoesc.pessoaservice.restapi.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.converters.TipoDocumentoDTOConverter;
import br.edu.unoesc.pessoaservice.restapi.dto.TipoDocumentoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.AbstractIdentityRestController;

@RestController
@RequestMapping(value = PessoaRestapiConstants.TIPO_DOCUMENTO_V1)
public class TipoDocumentoRestController extends AbstractIdentityRestController<TipoDocumento, Long, TipoDocumentoDTO, TipoDocumentoService, TipoDocumentoDTOConverter> {

}
