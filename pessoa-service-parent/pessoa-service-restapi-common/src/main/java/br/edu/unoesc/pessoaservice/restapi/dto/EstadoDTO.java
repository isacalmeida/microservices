package br.edu.unoesc.pessoaservice.api.dto.cep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoDTO {

	private Long id;
	
	private String descricao;
	
	private String sigla;
}
