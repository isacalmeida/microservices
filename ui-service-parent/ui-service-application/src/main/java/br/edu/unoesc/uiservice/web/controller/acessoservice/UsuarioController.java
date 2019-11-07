package br.edu.unoesc.uiservice.web.controller.acessoservice;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unoesc.acessoservice.common.model.Usuario;
import br.edu.unoesc.uiservice.api.proxy.AcessoServiceProxy;
import br.edu.unoesc.uiservice.web.controller.utils.DefaultController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/usuarios")
public class UsuarioController extends DefaultController<Usuario, AcessoServiceProxy> {

	@Override
	public ModelAndView home() {
		List<Usuario> usuarios = proxy.getAllUsuario();
        Integer port = proxy.getPortUsuario();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuarios", usuarios);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("usuarios/index");
        return modelAndView;
	}

	@Override
	public ModelAndView novo() {
		Integer port = proxy.getPortUsuario();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("usuario", new Usuario());
		modelAndView.addObject("port", port);
		modelAndView.setViewName("usuarios/novo");
		return modelAndView;
	}

	@Override
	public ModelAndView getOne(@PathVariable Long id) {
		Usuario usuario = proxy.getOneUsuario(id);
        Integer port = proxy.getPortUsuario();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usuario", usuario);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("usuarios/editar");
        return modelAndView;
	}

	@Override
	public ModelAndView excluir(@PathVariable Long id) {
		Usuario usuario = proxy.getOneUsuario(id);
        log.info("USUARIO ENVIADO: {}", usuario);
    	proxy.deleteUsuario(usuario.getId());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/usuarios");
        return modelAndView;
	}

	@Override
	public ModelAndView salvar(@ModelAttribute Usuario usuario) {
		log.info("USUARIO ENVIADO: {}", usuario);
        Usuario usuarioCreated = proxy.createUsuario(usuario);
        log.info("USUARIO SALVO: {}", usuarioCreated);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/usuarios");
        return modelAndView;
	}

	@Override
	public ModelAndView atualizar(@ModelAttribute Usuario usuario) {
		log.info("USUARIO ENVIADO: {}", usuario);
		Usuario usuarioUpdated = proxy.updateUsuario(usuario.getId(), usuario);
        log.info("USUARIO SALVO: {}", usuarioUpdated);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/usuarios");
        return modelAndView;
	}

}
