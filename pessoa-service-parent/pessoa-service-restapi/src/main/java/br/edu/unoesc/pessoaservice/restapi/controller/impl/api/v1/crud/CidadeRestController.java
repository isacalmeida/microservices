package br.edu.unoesc.pessoaservice.restapi.controller.impl.api.v1.crud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.business.common.service.CidadeService;
import br.edu.unoesc.pessoaservice.common.model.Cidade;
import br.edu.unoesc.pessoaservice.restapi.common.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.common.dto.CidadeDTO;
import br.edu.unoesc.pessoaservice.restapi.converter.CidadeDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractRestController;

@RestController
@RequestMapping(PessoaRestapiConstants.CIDADE_V1)
public class CidadeRestController extends AbstractRestController<Cidade, CidadeDTO, CidadeService, CidadeDTOConverter> {

}
