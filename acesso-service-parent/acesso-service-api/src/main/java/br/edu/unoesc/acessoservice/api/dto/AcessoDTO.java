package br.edu.unoesc.acessoservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcessoDTO {

	private Long id;
	
	private Boolean ler;
	
	private Boolean criar;
	
	private Boolean alterar;
	
	private Boolean remover;
	
	private PerfilDTO perfil;
	
	private UsuarioDTO usuario;
}
