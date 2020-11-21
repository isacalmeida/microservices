package br.edu.unoesc.operacaoservice.restapi.common.dto;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.PersistableDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EventoDTO extends PersistableDTO<EventoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idEvento;

	private String descricao;

	private StatusEventoDTO statusEvento;

	private Long protocoloMudanca;

	@Override
	public Long getId() {
		return getIdEvento();
	}

	@Override
	public void setId(Long id) {
		setIdEvento(id);
	}
}
