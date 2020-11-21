package br.edu.unoesc.acessoservice.restapi.common.dto;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TipoServicoDTO extends AbstractDTO<TipoServicoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idTipoServico;

	private String descricao;

	@Override
	public Long getId() {
		return getIdTipoServico();
	}

	@Override
	public void setId(Long id) {
		setIdTipoServico(id);
	}
}
