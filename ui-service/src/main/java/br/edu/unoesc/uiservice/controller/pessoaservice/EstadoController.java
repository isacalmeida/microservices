package br.edu.unoesc.uiservice.controller.pessoaservice;

import br.edu.unoesc.uiservice.model.pessoaservice.Estado;
import br.edu.unoesc.uiservice.proxy.PessoaServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/estados")
public class EstadoController {

    // == fields ==
    private PessoaServiceProxy pessoaServiceProxy;

    // == constructors ==
    @Autowired
    public EstadoController(PessoaServiceProxy pessoaServiceProxy){
        this.pessoaServiceProxy = pessoaServiceProxy;
    }

    // == public methods ==
    @GetMapping
    public ModelAndView home(){
        List<Estado> estados = pessoaServiceProxy.getAllEstado();
        Integer port = pessoaServiceProxy.getPortEstado();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("estados", estados);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("estados/index");
        return modelAndView;
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        Integer port = pessoaServiceProxy.getPortEstado();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("estado", new Estado());
        modelAndView.addObject("port", port);
        modelAndView.setViewName("estados/novo");
        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView getOne(@PathVariable Long id){
        Estado estado = pessoaServiceProxy.getOneEstado(id);
        Integer port = pessoaServiceProxy.getPortEstado();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("estado", estado);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("estados/editar");
        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        Estado estado = pessoaServiceProxy.getOneEstado(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/estados");
        return modelAndView;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute Estado estado){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/estados");
        return modelAndView;
    }

    @PostMapping("/atualizar")
    public ModelAndView atualizar(@ModelAttribute Estado estado) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/estados");
        return modelAndView;
    }
}