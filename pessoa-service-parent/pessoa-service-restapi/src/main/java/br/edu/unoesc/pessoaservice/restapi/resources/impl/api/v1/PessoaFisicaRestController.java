package br.edu.unoesc.pessoaservice.restapi.resources.impl.api.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.common.model.PessoaFisica;
import br.edu.unoesc.pessoaservice.persistence.service.PessoaFisicaService;
import br.edu.unoesc.pessoaservice.restapi.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.converters.PessoaFisicaDTOConverter;
import br.edu.unoesc.pessoaservice.restapi.dto.PessoaFisicaDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.AbstractMasterRestController;

@RestController
@RequestMapping(PessoaRestapiConstants.PESSOAFISICA_V1)
public class PessoaFisicaRestController extends AbstractMasterRestController<PessoaFisica, PessoaFisicaDTO, PessoaFisicaService, PessoaFisicaDTOConverter> {

}
