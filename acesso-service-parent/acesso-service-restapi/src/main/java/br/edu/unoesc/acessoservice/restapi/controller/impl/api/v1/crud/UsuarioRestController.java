package br.edu.unoesc.acessoservice.restapi.controller.impl.api.v1.crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.acessoservice.business.common.service.UsuarioService;
import br.edu.unoesc.acessoservice.common.model.Usuario;
import br.edu.unoesc.acessoservice.restapi.common.constants.AcessoRestapiConstants;
import br.edu.unoesc.acessoservice.restapi.common.dto.UsuarioDTO;
import br.edu.unoesc.acessoservice.restapi.converter.UsuarioDTOConverter;
import br.edu.unoesc.sistemautils.arquitetura.restapi.controller.impl.AbstractRestController;

@RestController
@RequestMapping(AcessoRestapiConstants.USUARIO_V1)
public class UsuarioRestController extends AbstractRestController<Usuario, UsuarioDTO, UsuarioService, UsuarioDTOConverter> {

	@PostMapping("autenticacao")
	public ResponseEntity<UsuarioDTO> findUsuarioAutenticado(@RequestBody UsuarioDTO usuario) {
		return getService().getUsuarioAutenticado(usuario.getLogin(), usuario.getSenha())
		.map(entity -> ResponseEntity.ok().body(getConverter().convertToDTO(entity)))
		.orElse(ResponseEntity.notFound().build());
	}
}
