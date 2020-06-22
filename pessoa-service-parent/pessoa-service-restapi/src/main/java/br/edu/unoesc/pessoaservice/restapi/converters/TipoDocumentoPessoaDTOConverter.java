package br.edu.unoesc.pessoaservice.restapi.converters;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.Pessoa;
import br.edu.unoesc.pessoaservice.common.model.TipoDocumentoPessoa;
import br.edu.unoesc.pessoaservice.restapi.dto.TipoDocumentoPessoaDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DetailDTOConverter;

@Component
public class TipoDocumentoPessoaDTOConverter extends DetailDTOConverter<Pessoa, TipoDocumentoPessoa, TipoDocumentoPessoaDTO> {

	public TipoDocumentoPessoaDTOConverter() {
		super(TipoDocumentoPessoa.class, TipoDocumentoPessoaDTO.class);
	}
}
