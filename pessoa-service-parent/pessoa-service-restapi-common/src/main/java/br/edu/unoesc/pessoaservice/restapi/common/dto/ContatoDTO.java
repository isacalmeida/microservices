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
public class ContatoDTO extends AbstractDTO<ContatoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idContato;

	private String descricao;

	private TipoContatoDTO tipoContato;

	@Override
	public Long getId() {
		return getIdContato();
	}

	@Override
	public void setId(Long id) {
		setIdContato(id);
	}
}
