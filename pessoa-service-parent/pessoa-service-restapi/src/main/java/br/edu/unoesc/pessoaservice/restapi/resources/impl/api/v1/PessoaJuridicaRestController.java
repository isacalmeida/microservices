package br.edu.unoesc.pessoaservice.restapi.resources.impl.api.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.common.model.PessoaJuridica;
import br.edu.unoesc.pessoaservice.persistence.service.PessoaJuridicaService;
import br.edu.unoesc.pessoaservice.restapi.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.converters.PessoaJuridicaDTOConverter;
import br.edu.unoesc.pessoaservice.restapi.dto.PessoaJuridicaDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.AbstractMasterRestController;

@RestController
@RequestMapping(PessoaRestapiConstants.PESSOAJURIDICA_V1)
public class PessoaJuridicaRestController extends AbstractMasterRestController<PessoaJuridica, PessoaJuridicaDTO, PessoaJuridicaService, PessoaJuridicaDTOConverter> {

}
