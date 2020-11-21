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
public class IncidenteDTO extends PersistableDTO<IncidenteDTO> {

	private static final long serialVersionUID = 1L;

	private Long idIncidente;

	private String descricao;

	private StatusIncidenteDTO statusIncidente;

	private PrioridadeDTO prioridade;

	private ImpactoDTO impacto;

	private EventoDTO evento;

	private RequisicaoDTO requisicao;

	private String resolucao;

	private Long protocoloItemConfiguracao;

	@Override
	public Long getId() {
		return getIdIncidente();
	}

	@Override
	public void setId(Long id) {
		setIdIncidente(id);
	}
}
