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
public class TipoDocumentoDTO extends AbstractDTO<TipoDocumentoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idTipoDocumento;

	private String descricao;

	private Long caracteres;

	private TipoPessoaDTO tipoPessoa;

	@Override
	public Long getId() {
		return getIdTipoDocumento();
	}

	@Override
	public void setId(Long id) {
		setIdTipoDocumento(id);
	}
}
