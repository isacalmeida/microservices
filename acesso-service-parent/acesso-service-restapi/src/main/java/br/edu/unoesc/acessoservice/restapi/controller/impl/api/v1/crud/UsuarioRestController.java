package br.edu.unoesc.acessoservice.restapi.controller.impl.api.v1.crud;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.edu.unoesc.sistemautils.shared.restapi.common.pessoa.PessoaFisicaDTO;
import br.edu.unoesc.sistemautils.shared.restapi.zuul.ZuulClient;

@RestController
@RequestMapping(AcessoRestapiConstants.USUARIO_V1)
public class UsuarioRestController extends AbstractRestController<Usuario, UsuarioDTO, UsuarioService, UsuarioDTOConverter> {

	@Autowired
	private ZuulClient zuulClient;

	@PostMapping("autenticacao")
	public ResponseEntity<UsuarioDTO> findUsuarioAutenticado(@RequestBody UsuarioDTO usuario) {
		return getService().getUsuarioAutenticado(usuario.getLogin(), usuario.getSenha())
		.map(entity -> ResponseEntity.ok().body(getConverter().convertToDTO(entity)))
		.orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<UsuarioDTO> getOne(Long id) {
		ResponseEntity<UsuarioDTO> responseEntity = super.getOne(id);
		if(responseEntity.hasBody()) {

			UsuarioDTO usuario = responseEntity.getBody();
			popularPessoaFisica(usuario);
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<UsuarioDTO> update(Long id, UsuarioDTO dto) {
		ResponseEntity<UsuarioDTO> responseEntity = super.update(id, dto);
		if(responseEntity.hasBody()) {

			UsuarioDTO usuario = responseEntity.getBody();
			popularPessoaFisica(usuario);
		}
		return responseEntity;
	}

	private void popularPessoaFisica(UsuarioDTO usuario) {
		Long idPessoa = usuario.getProtocoloPessoa();
		PessoaFisicaDTO pessoaFisica = zuulClient.getOnePessoaFisica(idPessoa);
		usuario.setPessoaFisica(pessoaFisica);
	}
}
