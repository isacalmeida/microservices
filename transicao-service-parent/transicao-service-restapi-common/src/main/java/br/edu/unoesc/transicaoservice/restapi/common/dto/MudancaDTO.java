package br.edu.unoesc.transicaoservice.restapi.common.dto;

import java.util.Date;
import java.util.List;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.PersistableDTO;
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

	private Long protocoloProblema;

	private String atividades;

	private String planoRetorno;

	private List<MudancaItemConfiguracaoDTO> mudancaItemConfiguracao;

	@Override
	public Long getId() {
		return getIdMudanca();
	}

	@Override
	public void setId(Long id) {
		setIdMudanca(id);
	}
}
