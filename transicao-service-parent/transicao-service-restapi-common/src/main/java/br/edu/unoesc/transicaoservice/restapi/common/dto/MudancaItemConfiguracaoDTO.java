package br.edu.unoesc.transicaoservice.restapi.common.dto;

import br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto.PersistableDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MudancaItemConfiguracaoDTO extends PersistableDTO<MudancaItemConfiguracaoDTO> {

	private static final long serialVersionUID = 1L;

	private Long idMudancaItemConfiguracao;

	private ItemConfiguracaoDTO itemConfiguracao;

	@Override
	public Long getId() {
		return getIdMudancaItemConfiguracao();
	}

	@Override
	public void setId(Long id) {
		setIdMudancaItemConfiguracao(id);
	}
}
