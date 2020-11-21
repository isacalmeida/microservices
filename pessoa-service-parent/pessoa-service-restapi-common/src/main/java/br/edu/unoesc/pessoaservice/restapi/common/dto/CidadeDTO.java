package br.edu.unoesc.pessoaservice.restapi.common.dto;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.PersistableDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CidadeDTO extends PersistableDTO<CidadeDTO> {

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
