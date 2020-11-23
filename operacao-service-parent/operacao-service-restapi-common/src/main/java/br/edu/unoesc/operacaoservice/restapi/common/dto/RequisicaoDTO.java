package br.edu.unoesc.operacaoservice.restapi.common.dto;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.PersistableDTO;
import br.edu.unoesc.sistemautils.shared.restapi.common.transicao.MudancaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RequisicaoDTO extends PersistableDTO<RequisicaoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idRequisicao;

	private String descricao;

	private StatusRequisicaoDTO statusRequisicao;

	private Long protocoloMudanca;

	private MudancaDTO mudanca;

	@Override
	public Long getId() {
		return getIdRequisicao();
	}

	@Override
	public void setId(Long id) {
		setIdRequisicao(id);
	}
}
