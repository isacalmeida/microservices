package br.edu.unoesc.pessoaservice.api.dto.cep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CidadeDTO {

	private Long id;
	
	private String descricao;
	
	private EstadoDTO estado;
}
