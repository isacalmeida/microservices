package br.edu.unoesc.pessoaservice.api.dto.pessoa;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

	private Long id;
	
	private String cpf;
	
	private String nomeCompleto;
	
	private String cnpj;
	
	private String razaoSocial;
	
	List<EnderecoDTO> enderecos;
	
	List<ContatoDTO> contatos;
}
