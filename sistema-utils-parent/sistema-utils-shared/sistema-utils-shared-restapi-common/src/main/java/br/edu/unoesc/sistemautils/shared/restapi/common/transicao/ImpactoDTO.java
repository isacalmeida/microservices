package br.edu.unoesc.sistemautils.shared.restapi.common.transicao;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ImpactoDTO extends AbstractDTO<ImpactoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idImpacto;

	private String descricao;

	@Override
	public Long getId() {
		return getIdImpacto();
	}

	@Override
	public void setId(Long id) {
		setIdImpacto(id);
	}
}
