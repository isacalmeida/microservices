package br.edu.unoesc.uiservice.web.controller.pessoaservice;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unoesc.pessoaservice.common.model.cep.Estado;
import br.edu.unoesc.uiservice.api.proxy.PessoaServiceProxy;
import br.edu.unoesc.uiservice.web.controller.utils.DefaultController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/estados")
public class EstadoController extends DefaultController<Estado, PessoaServiceProxy> {

    // == public methods ==
    @Override
    public ModelAndView home(){
        List<Estado> estados = proxy.getAllEstado();
        Integer port = proxy.getPortEstado();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("estados", estados);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("estados/index");
        return modelAndView;
    }

    @Override
    public ModelAndView novo(){
        Integer port = proxy.getPortEstado();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("estado", new Estado());
        modelAndView.addObject("port", port);
        modelAndView.setViewName("estados/novo");
        return modelAndView;
    }

    @Override
    public ModelAndView getOne(@PathVariable Long id){
        Estado estado = proxy.getOneEstado(id);
        Integer port = proxy.getPortEstado();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("estado", estado);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("estados/editar");
        return modelAndView;
    }

    @Override
    public ModelAndView excluir(@PathVariable Long id) {
        Estado estado = proxy.getOneEstado(id);
        log.info("ESTADO ENVIADO: {}", estado);
    	proxy.deleteEstado(estado.getId());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/estados");
        return modelAndView;
    }

    @Override
    public ModelAndView salvar(@ModelAttribute Estado estado){
    	log.info("ESTADO ENVIADO: {}", estado);
        Estado estadoCreated = proxy.createEstado(estado);
        log.info("ESTADO SALVO: {}", estadoCreated);
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/estados");
        return modelAndView;
    }

    @Override
    public ModelAndView atualizar(@ModelAttribute Estado estado) {
    	log.info("ESTADO ENVIADO: {}", estado);
        Estado estadoUpdated = proxy.updateEstado(estado.getId(), estado);
        log.info("ESTADO SALVO: {}", estadoUpdated);
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/estados");
        return modelAndView;
    }
}
