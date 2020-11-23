package br.edu.unoesc.pessoaservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.PessoaJuridica;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.MasterDTOConverter;
import br.edu.unoesc.sistemautils.shared.restapi.common.pessoa.PessoaJuridicaDTO;

@Component
public class PessoaJuridicaDTOConverter extends MasterDTOConverter<PessoaJuridica, PessoaJuridicaDTO> {

	protected PessoaJuridicaDTOConverter() {
		super(PessoaJuridica.class, PessoaJuridicaDTO.class);
	}
}
