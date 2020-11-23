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
public class CategoriaItemConfiguracaoDTO extends AbstractDTO<CategoriaItemConfiguracaoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idCategoriaItemConfiguracao;

	private String descricao;

	@Override
	public Long getId() {
		return getIdCategoriaItemConfiguracao();
	}

	@Override
	public void setId(Long id) {
		setIdCategoriaItemConfiguracao(id);
	}
}
