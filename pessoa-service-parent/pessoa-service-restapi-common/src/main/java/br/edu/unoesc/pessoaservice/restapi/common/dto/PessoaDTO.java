package br.edu.unoesc.pessoaservice.restapi.common.dto;

import java.util.List;

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

	private List<ContatoDTO> contatos;

	private List<EnderecoDTO> enderecos;

	private List<TipoDocumentoPessoaDTO> tipoDocumentoPessoa;

	@Override
	public Long getId() {
		return getIdPessoa();
	}

	@Override
	public void setId(Long id) {
		setIdPessoa(id);
	}
}
