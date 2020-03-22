package br.edu.unoesc.pessoaservice.api.dto.cep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CepDTO {

	private Long id;
	
	private String cep;
	
	private String logradouro;
	
	private String bairro;
	
	private String ibge;
	
	private CidadeDTO cidade;
}
