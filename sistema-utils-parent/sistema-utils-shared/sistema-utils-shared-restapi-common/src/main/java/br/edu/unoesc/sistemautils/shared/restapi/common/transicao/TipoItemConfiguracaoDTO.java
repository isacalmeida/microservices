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
public class TipoItemConfiguracaoDTO extends AbstractDTO<TipoItemConfiguracaoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idTipoItemConfiguracao;

	private String descricao;

	@Override
	public Long getId() {
		return getIdTipoItemConfiguracao();
	}

	@Override
	public void setId(Long id) {
		setIdTipoItemConfiguracao(id);
	}
}
