package br.edu.unoesc.pessoaservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.business.common.service.TipoDocumentoService;
import br.edu.unoesc.pessoaservice.common.model.TipoDocumento;
import br.edu.unoesc.pessoaservice.restapi.common.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.common.dto.TipoDocumentoDTO;
import br.edu.unoesc.pessoaservice.restapi.converter.TipoDocumentoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;

@RestController
@RequestMapping(value = PessoaRestapiConstants.TIPO_DOCUMENTO_V1)
public class TipoDocumentoRestController extends AbstractIdentityRestController<TipoDocumento, Long, TipoDocumentoDTO, TipoDocumentoService, TipoDocumentoDTOConverter> {

}
