package br.edu.unoesc.pessoaservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.PessoaFisica;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.MasterDTOConverter;
import br.edu.unoesc.sistemautils.shared.restapi.common.pessoa.PessoaFisicaDTO;

@Component
public class PessoaFisicaDTOConverter extends MasterDTOConverter<PessoaFisica, PessoaFisicaDTO> {

	public PessoaFisicaDTOConverter() {
		super(PessoaFisica.class, PessoaFisicaDTO.class);
	}
}
