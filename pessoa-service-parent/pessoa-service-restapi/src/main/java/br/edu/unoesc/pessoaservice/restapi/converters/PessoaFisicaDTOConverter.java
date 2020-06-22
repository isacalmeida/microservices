package br.edu.unoesc.pessoaservice.restapi.converters;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.PessoaFisica;
import br.edu.unoesc.pessoaservice.restapi.dto.PessoaFisicaDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.MasterDTOConverter;

@Component
public class PessoaFisicaDTOConverter extends MasterDTOConverter<PessoaFisica, PessoaFisicaDTO> {

	public PessoaFisicaDTOConverter() {
		super(PessoaFisica.class, PessoaFisicaDTO.class);
	}
}
