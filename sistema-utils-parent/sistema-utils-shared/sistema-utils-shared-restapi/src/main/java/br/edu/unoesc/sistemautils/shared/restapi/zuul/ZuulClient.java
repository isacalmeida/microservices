package br.edu.unoesc.sistemautils.shared.restapi.zuul;

import static br.edu.unoesc.sistemautils.shared.restapi.common.SistemaUtilsRestapiConstants.PESSOA_V1;
import static br.edu.unoesc.sistemautils.shared.restapi.common.SistemaUtilsRestapiConstants.TRANSICAO_V1;
import static br.edu.unoesc.sistemautils.shared.restapi.common.SistemaUtilsRestapiConstants.ZUUL_SERVER;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.unoesc.sistemautils.shared.restapi.common.pessoa.PessoaFisicaDTO;
import br.edu.unoesc.sistemautils.shared.restapi.common.pessoa.PessoaJuridicaDTO;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.ItemConfiguracaoDTO;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.MudancaDTO;

@FeignClient(ZUUL_SERVER)
public interface ZuulClient {

	public static final String PESSOA_FISICA_V1 = PESSOA_V1 + "/pessoa/pessoafisica";
	public static final String PESSOA_JURIDICA_V1 = PESSOA_V1 + "/pessoa/pessoajuridica";
	public static final String ITEM_CONFIGURACAO_V1 = TRANSICAO_V1 + "/itemconfiguracao";
	public static final String MUDANCA_V1 = TRANSICAO_V1 + "/mudanca";

	@GetMapping(ITEM_CONFIGURACAO_V1 + "/{id}")
    ItemConfiguracaoDTO getOneItemConfiguracao(@PathVariable("id") Long id);

	@GetMapping(MUDANCA_V1 + "/{id}")
    MudancaDTO getOneMudanca(@PathVariable("id") Long id);

	@GetMapping(PESSOA_FISICA_V1 + "/{id}")
    PessoaFisicaDTO getOnePessoaFisica(@PathVariable("id") Long id);

	@GetMapping(PESSOA_JURIDICA_V1 + "/{id}")
    PessoaJuridicaDTO getOnePessoaJuridica(@PathVariable("id") Long id);
}
