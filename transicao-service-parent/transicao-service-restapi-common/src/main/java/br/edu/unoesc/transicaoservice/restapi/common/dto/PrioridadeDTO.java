package br.edu.unoesc.transicaoservice.restapi.common.dto;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PrioridadeDTO extends AbstractDTO<PrioridadeDTO> {

	private static final long serialVersionUID = 1L;

	private Long idPrioridade;

	private String descricao;

	@Override
	public Long getId() {
		return getIdPrioridade();
	}

	@Override
	public void setId(Long id) {
		setIdPrioridade(id);
	}
}