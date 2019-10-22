package br.edu.unoesc.uiservice.web.controller.acessoservice;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unoesc.acessoservice.common.model.Programa;
import br.edu.unoesc.uiservice.api.proxy.AcessoServiceProxy;
import br.edu.unoesc.uiservice.web.controller.utils.DefaultController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/programas")
public class ProgramaController extends DefaultController<Programa, AcessoServiceProxy> {

	@Override
	public ModelAndView home() {
		List<Programa> programas = proxy.getAllPrograma();
        Integer port = proxy.getPortPrograma();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("programas", programas);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("programas/index");
        return modelAndView;
	}

	@Override
	public ModelAndView novo() {
		Integer port = proxy.getPortPrograma();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("programa", new Programa());
		modelAndView.addObject("port", port);
		modelAndView.setViewName("programas/novo");
		return modelAndView;
	}

	@Override
	public ModelAndView getOne(Long id) {
		Programa programa = proxy.getOnePrograma(id);
        Integer port = proxy.getPortPrograma();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("programa", programa);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("programas/editar");
        return modelAndView;
	}

	@Override
	public ModelAndView excluir(Long id) {
		Programa programa = proxy.getOnePrograma(id);
        log.info("PROGRAMA ENVIADO: {}", programa);
    	proxy.deletePrograma(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/programas");
        return modelAndView;
	}

	@Override
	public ModelAndView salvar(Programa programa) {
		log.info("PROGRAMA ENVIADO: {}", programa);
        Programa programaCreated = proxy.createPrograma(programa);
        log.info("PROGRAMA SALVO: {}", programaCreated);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/programas");
        return modelAndView;
	}

	@Override
	public ModelAndView atualizar(Programa programa) {
		log.info("PROGRAMA ENVIADO: {}", programa);
		Programa programaUpdated = proxy.updatePrograma(programa.getId(), programa);
        log.info("PROGRAMA SALVO: {}", programaUpdated);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/programas");
        return modelAndView;
	}
}
