package br.edu.unoesc.pessoaservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.Endereco;
import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.pessoaservice.restapi.common.dto.EnderecoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DetailDTOConverter;

@Component
public class EnderecoDTOConverter extends DetailDTOConverter<Pessoa, Endereco, EnderecoDTO> {

	public EnderecoDTOConverter() {
		super(Endereco.class, EnderecoDTO.class);
	}
}
