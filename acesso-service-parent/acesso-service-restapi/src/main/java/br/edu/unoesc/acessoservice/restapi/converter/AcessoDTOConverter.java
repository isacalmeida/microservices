package br.edu.unoesc.acessoservice.restapi.converter;

import org.springframework.stereotype.Component;

import br.edu.unoesc.acessoservice.common.model.Acesso;
import br.edu.unoesc.acessoservice.common.model.Perfil;
import br.edu.unoesc.acessoservice.restapi.common.dto.AcessoDTO;
import br.edu.unoesc.sistemautils.arquitetura.restapi.converter.DetailDTOConverter;

@Component
public class AcessoDTOConverter extends DetailDTOConverter<Perfil, Acesso, AcessoDTO> {

	public AcessoDTOConverter() {
		super(Acesso.class, AcessoDTO.class);
	}
}
