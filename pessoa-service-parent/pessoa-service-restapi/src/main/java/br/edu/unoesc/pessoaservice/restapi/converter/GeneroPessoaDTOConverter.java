package br.edu.unoesc.pessoaservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.GeneroPessoa;
import br.edu.unoesc.pessoaservice.restapi.common.dto.GeneroPessoaDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;

@Component
public class GeneroPessoaDTOConverter extends IdentityDTOConverter<GeneroPessoa, Long, GeneroPessoaDTO> {

	public GeneroPessoaDTOConverter() {
		super(GeneroPessoa.class, GeneroPessoaDTO.class);
	}
}
