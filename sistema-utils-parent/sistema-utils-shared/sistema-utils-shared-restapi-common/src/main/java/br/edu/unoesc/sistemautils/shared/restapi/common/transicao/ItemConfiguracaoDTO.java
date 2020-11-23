package br.edu.unoesc.sistemautils.shared.restapi.common.transicao;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.PersistableDTO;
import br.edu.unoesc.sistemautils.shared.restapi.common.pessoa.PessoaFisicaDTO;
import br.edu.unoesc.sistemautils.shared.restapi.common.pessoa.PessoaJuridicaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ItemConfiguracaoDTO extends PersistableDTO<ItemConfiguracaoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idItemConfiguracao;

	private String descricao;

	private ItemConfiguracaoDTO itemConfiguracaoSuperior;

	private StatusItemConfiguracaoDTO statusItemConfiguracao;

	private String modelo;

	private String numeroSerie;

	private String local;

	private String observacao;

	private CategoriaItemConfiguracaoDTO categoriaItemConfiguracao;

	private TipoItemConfiguracaoDTO tipoItemConfiguracao;

	private Long protocoloPessoaResponsavel;

	private Long protocoloPessoaFornecedor;

	private PessoaFisicaDTO pessoaFisica;

	private PessoaJuridicaDTO pessoaJuridica;

	@Override
	public Long getId() {
		return getIdItemConfiguracao();
	}

	@Override
	public void setId(Long id) {
		setIdItemConfiguracao(id);
	}
}
