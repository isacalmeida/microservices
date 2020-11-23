package br.edu.unoesc.transicaoservice.restapi.controller.impl.api.v1.crud.mudanca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractMasterRestController;
import br.edu.unoesc.sistemautils.shared.restapi.common.pessoa.PessoaFisicaDTO;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.MudancaDTO;
import br.edu.unoesc.sistemautils.shared.restapi.zuul.ZuulClient;
import br.edu.unoesc.transicaoservice.business.common.service.MudancaService;
import br.edu.unoesc.transicaoservice.common.model.Mudanca;
import br.edu.unoesc.transicaoservice.restapi.common.constants.TransicaoRestapiConstants;
import br.edu.unoesc.transicaoservice.restapi.converter.MudancaDTOConverter;

@RestController
@RequestMapping(value = TransicaoRestapiConstants.MUDANCA_V1)
public class MudancaRestController extends AbstractMasterRestController<Mudanca, MudancaDTO, MudancaService, MudancaDTOConverter> {

	@Autowired
	private ZuulClient zuulClient;

	@Override
	public ResponseEntity<MudancaDTO> getOne(Long id) {
		ResponseEntity<MudancaDTO> responseEntity = super.getOne(id);
		if(responseEntity.hasBody()) {

			MudancaDTO mudanca = responseEntity.getBody();
			popularPessoaFisica(mudanca);
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<MudancaDTO> update(Long id, MudancaDTO dto) {
		ResponseEntity<MudancaDTO> responseEntity = super.update(id, dto);
		if(responseEntity.hasBody()) {

			MudancaDTO mudanca = responseEntity.getBody();
			popularPessoaFisica(mudanca);
		}
		return responseEntity;
	}

	private void popularPessoaFisica(MudancaDTO mudanca) {
		Long idPessoa = mudanca.getProtocoloPessoa();
		PessoaFisicaDTO pessoaFisica = zuulClient.getOnePessoaFisica(idPessoa);
		mudanca.setPessoaFisica(pessoaFisica);
	}
}
