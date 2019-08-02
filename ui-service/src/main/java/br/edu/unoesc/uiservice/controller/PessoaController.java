package br.edu.unoesc.uiservice.controller;

import br.edu.unoesc.pessoaservice.model.Pessoa;
import br.edu.unoesc.uiservice.proxy.PessoaServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PessoaController {

    // == fields ==
    private PessoaServiceProxy pessoaServiceProxy;

    // == constructors ==
    @Autowired
    public PessoaController(PessoaServiceProxy pessoaServiceProxy){
        this.pessoaServiceProxy = pessoaServiceProxy;
    }

    // == public methods ==
    @GetMapping("/pessoas-feign")
    public ModelAndView getAll(){
        List<Pessoa> pessoas = pessoaServiceProxy.getAll();
        Integer port = pessoaServiceProxy.getPort();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pessoas", pessoas);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("pessoas/index");
        return modelAndView;
    }

    @GetMapping("/pessoas-feign/{id}")
    public ModelAndView getOne(@PathVariable Long id){
        Pessoa pessoa = pessoaServiceProxy.getOne(id);
        Integer port = pessoaServiceProxy.getPort();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pessoa", pessoa);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("pessoas/editar");
        return modelAndView;
    }
}
