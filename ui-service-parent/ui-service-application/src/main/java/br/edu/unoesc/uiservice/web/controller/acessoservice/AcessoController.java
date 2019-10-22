package br.edu.unoesc.uiservice.web.controller.acessoservice;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unoesc.acessoservice.common.model.Acesso;
import br.edu.unoesc.uiservice.api.proxy.AcessoServiceProxy;
import br.edu.unoesc.uiservice.web.controller.utils.DefaultController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/acessos")
public class AcessoController extends DefaultController<Acesso, AcessoServiceProxy>{

	@Override
	public ModelAndView home() {
		List<Acesso> acessos = proxy.getAllAcesso();
        Integer port = proxy.getPortAcesso();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("acessos", acessos);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("acessos/index");
        return modelAndView;
	}

	@Override
	public ModelAndView novo() {
        Integer port = proxy.getPortAcesso();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("port", port);
		modelAndView.setViewName("acessos/novo");
		return modelAndView;
	}

	@Override
	public ModelAndView getOne(Long id) {
		Acesso acesso = proxy.getOneAcesso(id);
        Integer port = proxy.getPortAcesso();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("acesso", acesso);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("acessos/editar");
        return modelAndView;
	}

	@Override
	public ModelAndView excluir(Long id) {
		Acesso acesso = proxy.getOneAcesso(id);
        log.info("ACESSO ENVIADO: {}", acesso);
    	proxy.deleteAcesso(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/acessos");
        return modelAndView;
	}

	@Override
	public ModelAndView salvar(Acesso acesso) {
		log.info("ACESSO ENVIADO: {}", acesso);
        Acesso acessoCreated = proxy.createAcesso(acesso);
        log.info("ACESSO SALVO: {}", acessoCreated);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/acessos");
        return modelAndView;
	}

	@Override
	public ModelAndView atualizar(Acesso acesso) {
		log.info("ACESSO ENVIADO: {}", acesso);
        Acesso acessoUpdated = proxy.updateAcesso(acesso.getId(), acesso);
        log.info("ACESSO SALVO: {}", acessoUpdated);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/acessos");
        return modelAndView;
	}
}
