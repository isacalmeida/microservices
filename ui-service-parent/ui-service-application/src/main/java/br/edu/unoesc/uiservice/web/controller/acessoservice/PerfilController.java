package br.edu.unoesc.uiservice.web.controller.acessoservice;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unoesc.acessoservice.common.model.Perfil;
import br.edu.unoesc.uiservice.api.proxy.AcessoServiceProxy;
import br.edu.unoesc.uiservice.web.controller.utils.DefaultController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/perfis")
public class PerfilController extends DefaultController<Perfil, AcessoServiceProxy> {
	
	@Override
	public ModelAndView home() {
		List<Perfil> perfis = proxy.getAllPerfil();
        Integer port = proxy.getPortPerfil();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("perfis", perfis);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("perfis/index");
        return modelAndView;
	}

	@Override
	public ModelAndView novo() {
		Integer port = proxy.getPortPerfil();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("perfil", new Perfil());
		modelAndView.addObject("port", port);
		modelAndView.setViewName("perfis/novo");
		return modelAndView;
	}

	@Override
	public ModelAndView getOne(Long id) {
		Perfil perfil = proxy.getOnePerfil(id);
        Integer port = proxy.getPortPerfil();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("perfil", perfil);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("perfis/editar");
        return modelAndView;
	}

	@Override
	public ModelAndView excluir(Long id) {
		Perfil perfil = proxy.getOnePerfil(id);
        log.info("PERFIL ENVIADO: {}", perfil);
    	proxy.deletePerfil(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/perfis");
        return modelAndView;
	}

	@Override
	public ModelAndView salvar(Perfil perfil) {
		log.info("PERFIL ENVIADO: {}", perfil);
        Perfil perfilCreated = proxy.createPerfil(perfil);
        log.info("PERFIL SALVO: {}", perfilCreated);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/perfis");
        return modelAndView;
	}

	@Override
	public ModelAndView atualizar(Perfil perfil) {
		log.info("PERFIL ENVIADO: {}", perfil);
        Perfil perfilUpdated = proxy.updatePerfil(perfil.getId(), perfil);
        log.info("PERFIL SALVO: {}", perfilUpdated);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/perfis");
        return modelAndView;
	}

}
