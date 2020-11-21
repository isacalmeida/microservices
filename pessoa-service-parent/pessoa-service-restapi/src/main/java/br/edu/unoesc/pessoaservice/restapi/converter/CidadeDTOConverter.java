package br.edu.unoesc.pessoaservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.Cidade;
import br.edu.unoesc.pessoaservice.restapi.common.dto.CidadeDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DTOConverter;

@Component
public class CidadeDTOConverter extends DTOConverter<Cidade, CidadeDTO> {

	public CidadeDTOConverter() {
		super(Cidade.class, CidadeDTO.class);
	}
}
