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
public class StatusEventoDTO extends AbstractDTO<StatusEventoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idStatusEvento;

	private String descricao;

	@Override
	public Long getId() {
		return getIdStatusEvento();
	}

	@Override
	public void setId(Long id) {
		setIdStatusEvento(id);
	}
}