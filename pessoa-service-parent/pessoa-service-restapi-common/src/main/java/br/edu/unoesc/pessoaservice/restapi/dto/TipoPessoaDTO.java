package br.edu.unoesc.pessoaservice.restapi.dto;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TipoPessoaDTO extends AbstractDTO<TipoPessoaDTO> {

	private static final long serialVersionUID = 1L;

	private Long idTipoPessoa;

	private String descricao;

	@Override
	public Long getId() {
		return getIdTipoPessoa();
	}

	@Override
	public void setId(Long id) {
		setIdTipoPessoa(id);
	}
}
