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
public class ProblemaDTO extends PersistableDTO<ProblemaDTO> {

	private static final long serialVersionUID = 1L;

	private Long idProblema;

	private String descricao;

	private StatusProblemaDTO statusProblema;

	private IncidenteDTO incidente;

	private ErroConhecidoDTO erroConhecido;

	private Long protocoloMudanca;

	@Override
	public Long getId() {
		return getIdProblema();
	}

	@Override
	public void setId(Long id) {
		setIdProblema(id);
	}
}
