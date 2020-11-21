package br.edu.unoesc.acessoservice.restapi.common.dto;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.PersistableDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AcessoDTO extends PersistableDTO<AcessoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idAcesso;
	
	private Boolean ler;

	private Boolean criar;

	private Boolean alterar;

	private Boolean remover;
	
	private ProgramaDTO programa;

	@Override
	public Long getId() {
		return getIdAcesso();
	}

	@Override
	public void setId(Long id) {
		setIdAcesso(id);
	}
}
