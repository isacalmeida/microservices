package br.edu.unoesc.acessoservice.restapi.common.dto;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.PersistableDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProgramaDTO extends PersistableDTO<ProgramaDTO> {

	private static final long serialVersionUID = 1L;

	private Long idPrograma;

	private String descricao;

	private String endereco;

	private String sigla;

	private TipoServicoDTO tipoServico;

	@Override
	public Long getId() {
		return getIdPrograma();
	}

	@Override
	public void setId(Long id) {
		setIdPrograma(id);
	}
}
