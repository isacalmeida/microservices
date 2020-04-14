package br.edu.unoesc.acessoservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

	private Long id;
	
	private String login;
	
	private String senha;
	
	private PerfilDTO perfil;
	
	private Long idPessoa;
}
