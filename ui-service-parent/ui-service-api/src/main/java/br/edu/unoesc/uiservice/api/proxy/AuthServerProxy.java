package br.edu.unoesc.uiservice.api.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;


@RibbonClient("auth-server")
@FeignClient("zuul-server")
public interface AuthServerProxy {

	//@GetMapping("/auth-server/oauth/token")
	//ResponseLoginDTO doLogin(Usuario usuario, RequestLoginDTO request);
	
	//@GetMapping("/auth-server/usuarios/{email}/email")
	//Usuario getOneByEmail(@PathVariable String email);
	
	//@PostMapping("/auth-server/usuarios")
	//Usuario createUsuario(@ModelAttribute Usuario usuario);
}
