package br.edu.unoesc.uiservice.controller.pessoaservice;

import br.edu.unoesc.uiservice.model.pessoaservice.Cep;
import br.edu.unoesc.uiservice.model.pessoaservice.Cidade;
import br.edu.unoesc.uiservice.model.pessoaservice.Estado;
import br.edu.unoesc.uiservice.proxy.PessoaServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/ceps")
public class CepController {

    // == fields ==
    private PessoaServiceProxy pessoaServiceProxy;

    // == constructors ==
    @Autowired
    public CepController(PessoaServiceProxy pessoaServiceProxy){
        this.pessoaServiceProxy = pessoaServiceProxy;
    }

    // == public methods ==
    @GetMapping
    public ModelAndView home(){
        List<Cep> ceps = pessoaServiceProxy.getAllCep();
        Integer port = pessoaServiceProxy.getPortCep();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ceps", ceps);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("ceps/index");
        return modelAndView;
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        List<Estado> estados = pessoaServiceProxy.getAllEstado();
        List<Cidade> cidades = pessoaServiceProxy.getAllCidade();
        Integer port = pessoaServiceProxy.getPortCep();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cep", new Cep());
        modelAndView.addObject("estados", estados);
        modelAndView.addObject("cidades", cidades);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("ceps/novo");
        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView getOne(@PathVariable Long id){
        List<Estado> estados = pessoaServiceProxy.getAllEstado();
        List<Cidade> cidades = pessoaServiceProxy.getAllCidade();
        Cep cep = pessoaServiceProxy.getOneCep(id);
        Integer port = pessoaServiceProxy.getPortCep();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cep", cep);
        modelAndView.addObject("estados", estados);
        modelAndView.addObject("cidades", cidades);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("ceps/editar");
        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        Cep cep = pessoaServiceProxy.getOneCep(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ceps");
        return modelAndView;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute Cep cep){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ceps");
        return modelAndView;
    }

    @PostMapping("/atualizar")
    public ModelAndView atualizar(@ModelAttribute Cep cep) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ceps");
        return modelAndView;
    }
}
