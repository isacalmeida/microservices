package br.edu.unoesc.operacaoservice.restapi.common.dto;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StatusRequisicaoDTO extends AbstractDTO<StatusRequisicaoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idStatusRequisicao;

	private String descricao;

	@Override
	public Long getId() {
		return getIdStatusRequisicao();
	}

	@Override
	public void setId(Long id) {
		setIdStatusRequisicao(id);
	}
}