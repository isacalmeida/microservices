package br.edu.unoesc.uiservice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	//@Autowired
	//private AuthServerProxy proxy;
	
//	@GetMapping
//	public ModelAndView home() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("registrar");
//		modelAndView.addObject("usuario", new Usuario());
//		return modelAndView;
//	}
//	
	/*@PostMapping
	public ModelAndView registrar(@Valid Usuario usuario, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		Usuario usr = proxy.getOneByEmail(usuario.getEmail());
		if(usr != null) {
			result.rejectValue("email", "", "Usuário já cadastrado");
		}
		if(result.hasErrors()) {
			mv.setViewName("registrar");
			mv.addObject("usuario", usuario);
		} else {
			proxy.createUsuario(usuario);
			mv.setViewName("redirect:/login");
		}
		return mv;
	}*/
}
