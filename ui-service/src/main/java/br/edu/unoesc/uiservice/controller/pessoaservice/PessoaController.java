package br.edu.unoesc.uiservice.controller.pessoaservice;

import br.edu.unoesc.uiservice.model.pessoaservice.Pessoa;
import br.edu.unoesc.uiservice.proxy.PessoaServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    // == fields ==
    private PessoaServiceProxy pessoaServiceProxy;

    // == constructors ==
    @Autowired
    public PessoaController(PessoaServiceProxy pessoaServiceProxy){
        this.pessoaServiceProxy = pessoaServiceProxy;
    }

    // == public methods ==
    @GetMapping
    public ModelAndView home(){
        List<Pessoa> pessoas = pessoaServiceProxy.getAllPessoa();
        Integer port = pessoaServiceProxy.getPortPessoa();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pessoas", pessoas);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("pessoas/index");
        return modelAndView;
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        Integer port = pessoaServiceProxy.getPortPessoa();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pessoa", new Pessoa());
        modelAndView.addObject("port", port);
        modelAndView.setViewName("pessoas/novo");
        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView getOne(@PathVariable Long id){
        Pessoa pessoa = pessoaServiceProxy.getOnePessoa(id);
        Integer port = pessoaServiceProxy.getPortPessoa();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pessoa", pessoa);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("pessoas/editar");
        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        Pessoa pessoa = pessoaServiceProxy.getOnePessoa(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/pessoas");
        return modelAndView;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute Pessoa pessoa){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/pessoas");
        return modelAndView;
    }

    @PostMapping("/atualizar")
    public ModelAndView atualizar(@ModelAttribute Pessoa pessoa) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/pessoas");
        return modelAndView;
    }
}
