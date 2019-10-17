package br.edu.unoesc.uiservice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController{
	
	//@Autowired
	//private AuthServerProxy proxy;
	
	//@Autowired
	//private UsuarioBean usuarioBean;
	
//	@GetMapping
//	public ModelAndView login() {
//		System.out.println("Loginnnn!!!!!");
//		ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        modelAndView.addObject("usuario", new Usuario());
//        return modelAndView;
//	}
//	
//	
//	@PostMapping
//	public ModelAndView logar(@ModelAttribute Usuario usuario) {
//		//usuarioBean.setUsuario(usuario);
//		System.out.println("Logando!!!!!");
//		System.out.println("Usuario: "+ usuario);
//		Usuario usuarioAuth = proxy.getOneByEmail(usuario.getEmail());
//		System.out.println("Usuario 2:"+ usuarioAuth);
//		ModelAndView modelAndView = new ModelAndView();
//		return modelAndView;
//	}
}
