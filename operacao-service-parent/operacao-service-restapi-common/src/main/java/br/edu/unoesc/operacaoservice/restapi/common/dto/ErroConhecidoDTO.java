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
public class ErroConhecidoDTO extends PersistableDTO<ErroConhecidoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idErroConhecido;

	private String descricao;

	private String observacao;

	@Override
	public Long getId() {
		return getIdErroConhecido();
	}

	@Override
	public void setId(Long id) {
		setIdErroConhecido(id);
	}
}
