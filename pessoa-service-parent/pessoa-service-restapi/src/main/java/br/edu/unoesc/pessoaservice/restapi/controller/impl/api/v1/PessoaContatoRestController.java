package br.edu.unoesc.pessoaservice.restapi.controller.impl.api.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.business.common.service.ContatoService;
import br.edu.unoesc.pessoaservice.common.model.Contato;
import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.pessoaservice.restapi.common.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.common.dto.ContatoDTO;
import br.edu.unoesc.pessoaservice.restapi.converter.ContatoDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.AbstractDetailRestController;

@RestController
@RequestMapping(value = PessoaRestapiConstants.PESSOA_CONTATO_V1)
public class PessoaContatoRestController extends AbstractDetailRestController<Pessoa, Contato, ContatoDTO, ContatoService, ContatoDTOConverter>{

}
