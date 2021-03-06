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
public class EnderecoDTO extends PersistableDTO<EnderecoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idEndereco;
	
	private String numero;
	
	private String complemento;
	
	private String observacao;
	
	private CepDTO cep;

	private TipoEnderecoDTO tipoEndereco;

	@Override
	public Long getId() {
		return getIdEndereco();
	}

	@Override
	public void setId(Long id) {
		setIdEndereco(id);
	}
}
