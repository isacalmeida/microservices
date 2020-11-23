package br.edu.unoesc.sistemautils.shared.restapi.common.transicao;

import java.util.Date;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.PersistableDTO;
import br.edu.unoesc.sistemautils.shared.restapi.common.pessoa.PessoaFisicaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MudancaDTO extends PersistableDTO<MudancaDTO> {

	private static final long serialVersionUID = 1L;

	private Long idMudanca;

	private String descricao;

	private StatusMudancaDTO statusMudanca;

	private Date dataProposta;

	private PrioridadeDTO prioridade;

	private ImpactoDTO impacto;

	private Boolean isAutorizado;

	private Date dataAutorizacao;

	private Long protocoloPessoa;

	private String atividades;

	private String planoRetorno;

	private PessoaFisicaDTO pessoaFisica;

	@Override
	public Long getId() {
		return getIdMudanca();
	}

	@Override
	public void setId(Long id) {
		setIdMudanca(id);
	}
}
