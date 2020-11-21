package br.edu.unoesc.pessoaservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.Cep;
import br.edu.unoesc.pessoaservice.restapi.common.dto.CepDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DTOConverter;

@Component
public class CepDTOConverter extends DTOConverter<Cep, CepDTO> {

	public CepDTOConverter() {
		super(Cep.class, CepDTO.class);
	}
}
