package br.edu.unoesc.pessoaservice.restapi.converters;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.PessoaJuridica;
import br.edu.unoesc.pessoaservice.restapi.converters.factory.MasterDTOConverter;
import br.edu.unoesc.pessoaservice.restapi.dto.PessoaJuridicaDTO;

@Component
public class PessoaJuridicaDTOConverter extends MasterDTOConverter<PessoaJuridica, PessoaJuridicaDTO> {

	protected PessoaJuridicaDTOConverter() {
		super(PessoaJuridica.class, PessoaJuridicaDTO.class);
	}
}
