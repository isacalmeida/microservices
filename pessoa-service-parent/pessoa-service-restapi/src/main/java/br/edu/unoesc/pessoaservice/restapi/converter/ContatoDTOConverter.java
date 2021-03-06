package br.edu.unoesc.pessoaservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.Contato;
import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.pessoaservice.restapi.common.dto.ContatoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DetailDTOConverter;

@Component
public class ContatoDTOConverter extends DetailDTOConverter<Pessoa, Contato, ContatoDTO> {

	public ContatoDTOConverter() {
		super(Contato.class, ContatoDTO.class);
	}
}
