package br.edu.unoesc.pessoaservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.TipoPessoa;
import br.edu.unoesc.pessoaservice.restapi.common.dto.TipoPessoaDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;

@Component
public class TipoPessoaDTOConverter extends IdentityDTOConverter<TipoPessoa, Long, TipoPessoaDTO> {

	public TipoPessoaDTOConverter() {
		super(TipoPessoa.class, TipoPessoaDTO.class);
	}
}
