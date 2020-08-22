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
public class TipoDocumentoPessoaDTO extends AbstractDTO<TipoDocumentoPessoaDTO> {

	private static final long serialVersionUID = 1L;

	private Long idTipoDocumentoPessoa;
	
	private TipoDocumentoDTO tipoDocumento;

	@Override
	public Long getId() {
		return getIdTipoDocumentoPessoa();
	}

	@Override
	public void setId(Long id) {
		setIdTipoDocumentoPessoa(id);
	}
}
