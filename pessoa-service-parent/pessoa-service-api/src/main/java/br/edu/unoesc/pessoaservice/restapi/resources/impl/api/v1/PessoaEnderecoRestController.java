package br.edu.unoesc.pessoaservice.restapi.resources.impl.api.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.common.model.Endereco;
import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.pessoaservice.persistence.service.EnderecoService;
import br.edu.unoesc.pessoaservice.restapi.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.converters.EnderecoDTOConverter;
import br.edu.unoesc.pessoaservice.restapi.dto.EnderecoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.AbstractDetailRestController;

@RestController
@RequestMapping(value = PessoaRestapiConstants.PESSOA_ENDERECO_V1)
public class PessoaEnderecoRestController extends AbstractDetailRestController<Pessoa, Endereco, EnderecoDTO, EnderecoService, EnderecoDTOConverter> {

}
