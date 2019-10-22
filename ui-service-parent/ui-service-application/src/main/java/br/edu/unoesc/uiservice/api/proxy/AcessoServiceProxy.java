package br.edu.unoesc.uiservice.api.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.edu.unoesc.acessoservice.common.model.Acesso;
import br.edu.unoesc.acessoservice.common.model.Perfil;
import br.edu.unoesc.acessoservice.common.model.Programa;
import br.edu.unoesc.acessoservice.common.model.Usuario;

@FeignClient("zuul-server")
@RibbonClient("acesso-service")
public interface AcessoServiceProxy {

	// == Proxy REST de Acesso
	@GetMapping("/acesso-service/acessos")
	List<Acesso> getAllAcesso();

	@GetMapping("/acesso-service/acessos/{idAcesso}")
	Acesso getOneAcesso(@PathVariable Long idAcesso);

	@PostMapping("/acesso-service/acessos")
	Acesso createAcesso(@ModelAttribute Acesso acesso);

	@PutMapping("/acesso-service/acessos/{idAcesso}")
	Acesso updateAcesso(@PathVariable Long idAcesso, @ModelAttribute Acesso acesso);

	@DeleteMapping("/acesso-service/acessos/{idAcesso}")
	void deleteAcesso(@PathVariable Long idAcesso);

	@GetMapping("/acesso-service/acessos/port")
	Integer getPortAcesso();


	// == Proxy REST de Perfil
	@GetMapping("/acesso-service/perfis")
	List<Perfil> getAllPerfil();

	@GetMapping("/acesso-service/perfis/{idPerfil}")
	Perfil getOnePerfil(@PathVariable Long idPerfil);

	@PostMapping("/acesso-service/perfis")
	Perfil createPerfil(@ModelAttribute Perfil perfil);

	@PutMapping("/acesso-service/perfis/{idPerfil}")
	Perfil updatePerfil(@PathVariable Long idPerfil, @ModelAttribute Perfil perfil);

	@DeleteMapping("/acesso-service/perfis/{idPerfil}")
	void deletePerfil(@PathVariable Long idPerfil);

	@GetMapping("/acesso-service/perfis/port")
	Integer getPortPerfil();


	// == Proxy REST de Programa
	@GetMapping("/acesso-service/programas")
	List<Programa> getAllPrograma();

	@GetMapping("/acesso-service/programas/{idPrograma}")
	Programa getOnePrograma(@PathVariable Long idPrograma);

	@PostMapping("/acesso-service/programas")
	Programa createPrograma(@ModelAttribute Programa programa);

	@PutMapping("/acesso-service/programas/{idPrograma}")
	Programa updatePrograma(@PathVariable Long idPrograma, @ModelAttribute Programa programa);

	@DeleteMapping("/acesso-service/programas/{idPrograma}")
	void deletePrograma(@PathVariable Long idPrograma);

	@GetMapping("/acesso-service/programas/port")
	Integer getPortPrograma();


	// == Proxy REST de Usuario
	@GetMapping("/acesso-service/usuarios")
	List<Usuario> getAllUsuario();

	@GetMapping("/acesso-service/usuarios/{idUsuario}")
	Usuario getOneUsuario(@PathVariable Long idUsuario);

	@PostMapping("/acesso-service/usuarios")
	Usuario createUsuario(@ModelAttribute Usuario usuario);

	@PutMapping("/acesso-service/usuarios/{idUsuario}")
	Usuario updateUsuario(@PathVariable Long idUsuario, @ModelAttribute Usuario usuario);

	@DeleteMapping("/acesso-service/usuarios/{idUsuario}")
	void deleteUsuario(@PathVariable Long idUsuario);

	@GetMapping("/acesso-service/usuarios/port")
	Integer getPortUsuario();

}
