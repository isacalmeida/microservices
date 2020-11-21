package br.edu.unoesc.acessoaservice.business.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.unoesc.acessoservice.business.common.service.UsuarioService;
import br.edu.unoesc.acessoservice.business.service.impl.UsuarioServiceImpl;
import br.edu.unoesc.acessoservice.common.model.Usuario;
import br.edu.unoesc.acessoservice.persistence.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
public class UsuarioServiceImplTest {
	
	@MockBean
	protected static UsuarioRepository usuarioRepository;

	@TestConfiguration
	static class CepServiceImplTestContextConfiguration {
		
		@Bean
		public UsuarioService cepService() {
			return new UsuarioServiceImpl();
		}
	}
	
	@Autowired
	private UsuarioService usuarioService;

	@Before
	public void setUp() {
		Usuario usuario = new Usuario();
		usuario.setLogin("admin");
		
		Mockito.when(usuarioRepository.findByLoginAndIsExcluido(usuario.getLogin(), Boolean.FALSE)).thenReturn(usuario);
	}
	
	@Test
	public void quandoSalvarUmCepDeveRetornarOMesmo() {
		String login = "admin";
		Usuario usuarioEncontrado = usuarioService.getOneByLogin(login);
		
		assertThat(usuarioEncontrado.getLogin()).isEqualTo(login);
	}
}
