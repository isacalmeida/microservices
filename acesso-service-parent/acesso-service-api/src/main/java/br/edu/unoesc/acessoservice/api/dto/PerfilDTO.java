package br.edu.unoesc.acessoservice.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerfilDTO {

	private Long id;
	
	private String descricao;
	
	List<AcessoDTO> acessos;
}
