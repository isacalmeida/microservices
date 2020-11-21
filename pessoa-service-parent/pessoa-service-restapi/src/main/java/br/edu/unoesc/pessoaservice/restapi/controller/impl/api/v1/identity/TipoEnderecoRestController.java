package br.edu.unoesc.pessoaservice.restapi.controller.impl.api.v1.identity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.business.common.service.TipoEnderecoService;
import br.edu.unoesc.pessoaservice.common.model.TipoEndereco;
import br.edu.unoesc.pessoaservice.restapi.common.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.common.dto.TipoEnderecoDTO;
import br.edu.unoesc.pessoaservice.restapi.converter.TipoEnderecoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractIdentityRestController;

@RestController
@RequestMapping(value = PessoaRestapiConstants.TIPO_ENDERECO_V1)
public class TipoEnderecoRestController extends AbstractIdentityRestController<TipoEndereco, Long, TipoEnderecoDTO, TipoEnderecoService, TipoEnderecoDTOConverter> {

}
