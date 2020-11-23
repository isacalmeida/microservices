package br.edu.unoesc.transicaoservice.restapi.controller.impl.api.v1.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractRestController;
import br.edu.unoesc.sistemautils.shared.restapi.common.pessoa.PessoaFisicaDTO;
import br.edu.unoesc.sistemautils.shared.restapi.common.pessoa.PessoaJuridicaDTO;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.ItemConfiguracaoDTO;
import br.edu.unoesc.sistemautils.shared.restapi.zuul.ZuulClient;
import br.edu.unoesc.transicaoservice.business.common.service.ItemConfiguracaoService;
import br.edu.unoesc.transicaoservice.common.model.ItemConfiguracao;
import br.edu.unoesc.transicaoservice.restapi.common.constants.TransicaoRestapiConstants;
import br.edu.unoesc.transicaoservice.restapi.converter.ItemConfiguracaoDTOConverter;

@RestController
@RequestMapping(value = TransicaoRestapiConstants.ITEM_CONFIGURACAO_V1)
public class ItemConfiguracaoRestController extends AbstractRestController<ItemConfiguracao, ItemConfiguracaoDTO, ItemConfiguracaoService, ItemConfiguracaoDTOConverter> {

	@Autowired
	private ZuulClient zuulClient;

	@Override
	public ResponseEntity<ItemConfiguracaoDTO> getOne(Long id) {
		ResponseEntity<ItemConfiguracaoDTO> responseEntity = super.getOne(id);
		if(responseEntity.hasBody()) {

			ItemConfiguracaoDTO itemConfiguracao = responseEntity.getBody();
			popularPessoaFisica(itemConfiguracao);
			popularPessoaJuridica(itemConfiguracao);
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<ItemConfiguracaoDTO> update(Long id, ItemConfiguracaoDTO dto) {
		ResponseEntity<ItemConfiguracaoDTO> responseEntity = super.update(id, dto);
		if(responseEntity.hasBody()) {

			ItemConfiguracaoDTO itemConfiguracao = responseEntity.getBody();
			popularPessoaFisica(itemConfiguracao);
			popularPessoaJuridica(itemConfiguracao);
		}
		return responseEntity;
	}

	private void popularPessoaFisica(ItemConfiguracaoDTO itemConfiguracao) {
		Long idPessoa = itemConfiguracao.getProtocoloPessoaResponsavel();
		PessoaFisicaDTO pessoaFisica = zuulClient.getOnePessoaFisica(idPessoa);
		itemConfiguracao.setPessoaFisica(pessoaFisica);
	}

	private void popularPessoaJuridica(ItemConfiguracaoDTO itemConfiguracao) {
		Long idPessoa = itemConfiguracao.getProtocoloPessoaFornecedor();
		PessoaJuridicaDTO pessoaFisica = zuulClient.getOnePessoaJuridica(idPessoa);
		itemConfiguracao.setPessoaJuridica(pessoaFisica);
	}
}
