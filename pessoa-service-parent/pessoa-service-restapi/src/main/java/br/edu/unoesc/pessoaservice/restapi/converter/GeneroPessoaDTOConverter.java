package br.edu.unoesc.pessoaservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.GeneroPessoa;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;
import br.edu.unoesc.sistemautils.shared.restapi.common.pessoa.GeneroPessoaDTO;

@Component
public class GeneroPessoaDTOConverter extends IdentityDTOConverter<GeneroPessoa, Long, GeneroPessoaDTO> {

	public GeneroPessoaDTOConverter() {
		super(GeneroPessoa.class, GeneroPessoaDTO.class);
	}
}
