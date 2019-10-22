package br.edu.unoesc.pessoaservice.api.dto.pessoa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDTO {

	private Long id;

	private String descricao;
}
