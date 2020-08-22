package br.edu.unoesc.pessoaservice.restapi.controller.impl.api.v1.crud.pessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.business.common.service.PessoaJuridicaService;
import br.edu.unoesc.pessoaservice.common.model.PessoaJuridica;
import br.edu.unoesc.pessoaservice.restapi.common.constants.PessoaRestapiConstants;
import br.edu.unoesc.pessoaservice.restapi.common.dto.PessoaJuridicaDTO;
import br.edu.unoesc.pessoaservice.restapi.converter.PessoaJuridicaDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractMasterRestController;

@RestController
@RequestMapping(PessoaRestapiConstants.PESSOAJURIDICA_V1)
public class PessoaJuridicaRestController extends AbstractMasterRestController<PessoaJuridica, PessoaJuridicaDTO, PessoaJuridicaService, PessoaJuridicaDTOConverter> {

}