package br.edu.unoesc.pessoaservice.restapi.converters;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.Endereco;
import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.pessoaservice.restapi.converters.factory.DetailDTOConverter;
import br.edu.unoesc.pessoaservice.restapi.dto.EnderecoDTO;

@Component
public class EnderecoDTOConverter extends DetailDTOConverter<Pessoa, Endereco, EnderecoDTO> {

	public EnderecoDTOConverter() {
		super(Endereco.class, EnderecoDTO.class);
	}
}
