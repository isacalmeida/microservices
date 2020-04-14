package br.edu.unoesc.pessoaservice.restapi.converters;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.Contato;
import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.pessoaservice.restapi.converters.factory.DetailDTOConverter;
import br.edu.unoesc.pessoaservice.restapi.dto.ContatoDTO;

@Component
public class ContatoDTOConverter extends DetailDTOConverter<Pessoa, Contato, ContatoDTO> {

	public ContatoDTOConverter() {
		super(Contato.class, ContatoDTO.class);
	}
}
