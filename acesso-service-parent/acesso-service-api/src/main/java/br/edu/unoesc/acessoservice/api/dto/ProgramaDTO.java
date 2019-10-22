package br.edu.unoesc.acessoservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgramaDTO {

	private Long id;
	
	private String descricao;
	
	private String endereco;
	
	private String servico;
}
