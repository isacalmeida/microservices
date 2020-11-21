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
public class GeneroPessoaDTO extends AbstractDTO<GeneroPessoaDTO> {

	private static final long serialVersionUID = 1L;

	private Long idGeneroPessoa;

	private String descricao;

	@Override
	public Long getId() {
		return getIdGeneroPessoa();
	}

	@Override
	public void setId(Long id) {
		setIdGeneroPessoa(id);
	}

}
