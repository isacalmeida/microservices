package br.edu.unoesc.sistemautils.shared.restapi.common.pessoa;

import org.springframework.hateoas.RepresentationModel;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.PersistableDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class PessoaDTO<DTO extends RepresentationModel<DTO>> extends PersistableDTO<DTO> {

	private static final long serialVersionUID = 1L;

	private Long idPessoa;

	private Boolean isCliente;

	private Boolean isFornecedor;

	private Boolean isFuncionario;

	@Override
	public Long getId() {
		return getIdPessoa();
	}

	@Override
	public void setId(Long id) {
		setIdPessoa(id);
	}
}
