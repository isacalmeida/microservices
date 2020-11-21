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
public class UsuarioDTO extends PersistableDTO<UsuarioDTO> {

	private static final long serialVersionUID = 1L;

	private Long idUsuario;

	private String login;

	private String senha;

	private Long protocoloPessoa;

	private PerfilDTO perfil;

	@Override
	public Long getId() {
		return getIdUsuario();
	}

	@Override
	public void setId(Long id) {
		setIdUsuario(id);
	}
}
