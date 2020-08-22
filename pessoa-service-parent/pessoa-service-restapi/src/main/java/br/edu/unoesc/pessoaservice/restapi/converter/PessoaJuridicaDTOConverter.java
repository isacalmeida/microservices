package br.edu.unoesc.pessoaservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.PessoaJuridica;
import br.edu.unoesc.pessoaservice.restapi.common.dto.PessoaJuridicaDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.MasterDTOConverter;

@Component
public class PessoaJuridicaDTOConverter extends MasterDTOConverter<PessoaJuridica, PessoaJuridicaDTO> {

	protected PessoaJuridicaDTOConverter() {
		super(PessoaJuridica.class, PessoaJuridicaDTO.class);
	}
}
