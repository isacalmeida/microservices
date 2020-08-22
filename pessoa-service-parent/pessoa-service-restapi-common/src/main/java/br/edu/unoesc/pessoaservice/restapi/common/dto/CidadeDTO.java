package br.edu.unoesc.pessoaservice.restapi.common.dto;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CidadeDTO extends AbstractDTO<CidadeDTO> {

	private static final long serialVersionUID = 1L;

	private Long idCidade;
	
	private String descricao;
	
	private EstadoDTO estado;

	@Override
	public Long getId() {
		return getIdCidade();
	}

	@Override
	public void setId(Long id) {
		setIdCidade(id);
	}
}
