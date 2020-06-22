package br.edu.unoesc.pessoaservice.restapi.converters;

import org.springframework.stereotype.Component;

import br.edu.unoesc.pessoaservice.common.model.TipoDocumento;
import br.edu.unoesc.pessoaservice.restapi.dto.TipoDocumentoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.IdentityDTOConverter;

@Component
public class TipoDocumentoDTOConverter extends IdentityDTOConverter<TipoDocumento, Long, TipoDocumentoDTO> {

	public TipoDocumentoDTOConverter() {
		super(TipoDocumento.class, TipoDocumentoDTO.class);
	}
}
