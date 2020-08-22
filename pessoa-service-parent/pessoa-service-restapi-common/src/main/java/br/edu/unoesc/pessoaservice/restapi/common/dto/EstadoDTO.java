package br.edu.unoesc.pessoaservice.restapi.common.dto;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EstadoDTO extends AbstractDTO<EstadoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idEstado;
	
	private String descricao;
	
	private String sigla;

	@Override
	public Long getId() {
		return getIdEstado();
	}

	@Override
	public void setId(Long id) {
		getIdEstado();
	}
}
