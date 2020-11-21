package br.edu.unoesc.acessoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.acessoservice.common.model.Perfil;
import br.edu.unoesc.acessoservice.restapi.common.dto.PerfilDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.MasterDTOConverter;

@Component
public class PerfilDTOConverter extends MasterDTOConverter<Perfil, PerfilDTO> {

	public PerfilDTOConverter() {
		super(Perfil.class, PerfilDTO.class);
	}
}
