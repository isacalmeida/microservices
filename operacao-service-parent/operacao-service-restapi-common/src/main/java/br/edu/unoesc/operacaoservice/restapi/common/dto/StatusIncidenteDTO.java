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
public class StatusIncidenteDTO extends AbstractDTO<StatusIncidenteDTO> {

	private static final long serialVersionUID = 1L;

	private Long idStatusIncidente;

	private String descricao;

	@Override
	public Long getId() {
		return getIdStatusIncidente();
	}

	@Override
	public void setId(Long id) {
		setIdStatusIncidente(id);
	}
}