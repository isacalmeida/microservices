package br.edu.unoesc.pessoaservice.api.dto.pessoa;

import br.edu.unoesc.pessoaservice.api.dto.cep.CepDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

	private Long id;
	
	private String numero;
	
	private String complemento;
	
	private String observacao;
	
	private CepDTO cep;
}
