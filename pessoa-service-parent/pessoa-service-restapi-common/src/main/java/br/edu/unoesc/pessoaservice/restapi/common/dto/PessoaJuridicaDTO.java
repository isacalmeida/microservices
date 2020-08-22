package br.edu.unoesc.pessoaservice.restapi.common.dto;

import java.util.List;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PessoaJuridicaDTO extends AbstractDTO<PessoaJuridicaDTO> {

	private static final long serialVersionUID = 1L;

	private Long idPessoa;

	private String cnpj;

	private String razaoSocial;

	List<ContatoDTO> contatos;

	List<EnderecoDTO> enderecos;

	List<TipoDocumentoPessoaDTO> tipoDocumentoPessoa;

	@Override
	public Long getId() {
		return getIdPessoa();
	}

	@Override
	public void setId(Long id) {
		setIdPessoa(id);
	}
}
