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
public class TipoEnderecoDTO extends AbstractDTO<TipoEnderecoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idTipoEndereco;

	private String descricao;

	@Override
	public Long getId() {
		return getIdTipoEndereco();
	}

	@Override
	public void setId(Long id) {
		setIdTipoEndereco(id);
	}
}
