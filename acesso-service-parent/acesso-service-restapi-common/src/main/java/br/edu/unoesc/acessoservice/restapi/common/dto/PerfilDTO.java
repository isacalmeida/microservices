package br.edu.unoesc.acessoservice.restapi.common.dto;

import java.util.List;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.PersistableDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PerfilDTO extends PersistableDTO<PerfilDTO> {

	private static final long serialVersionUID = 1L;

	private Long idPerfil;

	private String descricao;

	private List<AcessoDTO> acessos;

	@Override
	public Long getId() {
		return getIdPerfil();
	}

	@Override
	public void setId(Long id) {
		setIdPerfil(id);
	}
}
