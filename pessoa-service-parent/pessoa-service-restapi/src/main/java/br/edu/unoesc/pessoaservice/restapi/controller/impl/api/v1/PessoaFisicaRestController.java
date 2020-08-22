package br.edu.unoesc.pessoaservice.restapi.controller.impl.api.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.business.common.service.PessoaFisicaService;
import br.edu.unoesc.pessoaservice.common.model.PessoaFisica;
import br.edu.unoesc.pessoaservice.restapi.common.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.common.dto.PessoaFisicaDTO;
import br.edu.unoesc.pessoaservice.restapi.converter.PessoaFisicaDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.AbstractMasterRestController;

@RestController
@RequestMapping(PessoaRestapiConstants.PESSOAFISICA_V1)
public class PessoaFisicaRestController extends AbstractMasterRestController<PessoaFisica, PessoaFisicaDTO, PessoaFisicaService, PessoaFisicaDTOConverter> {

}
