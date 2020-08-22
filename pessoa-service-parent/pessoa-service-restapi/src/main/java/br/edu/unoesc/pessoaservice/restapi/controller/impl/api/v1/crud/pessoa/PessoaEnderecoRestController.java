package br.edu.unoesc.pessoaservice.restapi.controller.impl.api.v1.crud.pessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.business.common.service.EnderecoService;
import br.edu.unoesc.pessoaservice.common.model.Endereco;
import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.pessoaservice.restapi.common.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.common.dto.EnderecoDTO;
import br.edu.unoesc.pessoaservice.restapi.converter.EnderecoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractDetailRestController;

@RestController
@RequestMapping(value = PessoaRestapiConstants.PESSOA_ENDERECO_V1)
public class PessoaEnderecoRestController extends AbstractDetailRestController<Pessoa, Endereco, EnderecoDTO, EnderecoService, EnderecoDTOConverter> {

}
