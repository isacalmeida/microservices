package br.edu.unoesc.pessoaservice.restapi.common.dto;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.PersistableDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CepDTO extends PersistableDTO<CepDTO> {

	private static final long serialVersionUID = 1L;

	private Long idCep;

	private String cep;

	private String logradouro;

	private String bairro;

	private String ibge;

	private CidadeDTO cidade;

	@Override
	public Long getId() {
		return getIdCep();
	}

	@Override
	public void setId(Long id) {
		setIdCep(id);
	}
}
