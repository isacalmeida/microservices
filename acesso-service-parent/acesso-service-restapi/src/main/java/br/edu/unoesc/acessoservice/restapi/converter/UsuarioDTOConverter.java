package br.edu.unoesc.acessoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.acessoservice.common.model.Usuario;
import br.edu.unoesc.acessoservice.restapi.common.dto.UsuarioDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DTOConverter;

@Component
public class UsuarioDTOConverter extends DTOConverter<Usuario, UsuarioDTO> {

	public UsuarioDTOConverter() {
		super(Usuario.class, UsuarioDTO.class);
	}
}
