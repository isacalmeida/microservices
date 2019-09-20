package br.edu.unoesc.uiservice.controller.pessoaservice;

import br.edu.unoesc.uiservice.controller.utils.DefaultController;
import br.edu.unoesc.uiservice.controller.utils.EnumController;
import br.edu.unoesc.uiservice.model.pessoaservice.Pessoa;
import br.edu.unoesc.uiservice.model.pessoaservice.enums.EnumGeneroPessoa;
import br.edu.unoesc.uiservice.model.pessoaservice.enums.EnumTipoContato;
import br.edu.unoesc.uiservice.model.pessoaservice.enums.EnumTipoEndereco;
import br.edu.unoesc.uiservice.model.pessoaservice.enums.EnumTipoPessoa;
import br.edu.unoesc.uiservice.proxy.PessoaServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/pessoas")
public class PessoaController extends DefaultController<Pessoa, PessoaServiceProxy> {

    // == public methods ==
    @Override
    public ModelAndView home(){
        List<Pessoa> pessoas = proxy.getAllPessoa();
        Integer port = proxy.getPortPessoa();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pessoas", pessoas);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("pessoas/index");
        return modelAndView;
    }

    @Override
    public ModelAndView novo(){
        Integer port = proxy.getPortPessoa();

        Pessoa pessoa = new Pessoa();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pessoa", new Pessoa());
        modelAndView.addObject("port", port);
        modelAndView.addObject("tiposPessoa", EnumTipoPessoa.getList());
        modelAndView.addObject("generos", EnumGeneroPessoa.getList());
        modelAndView.setViewName("pessoas/novo");
        return modelAndView;
    }

    @Override
    public ModelAndView getOne(@PathVariable Long id){
        Pessoa pessoa = proxy.getOnePessoa(id);
        Integer port = proxy.getPortPessoa();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pessoa", pessoa);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("pessoas/editar");
        return modelAndView;
    }

    @Override
    public ModelAndView excluir(@PathVariable Long id) {
        Pessoa pessoa = proxy.getOnePessoa(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/pessoas");
        return modelAndView;
    }

    @Override
    public ModelAndView salvar(@ModelAttribute Pessoa pessoa){
        System.out.println("PESSOA SALVA: "+ pessoa);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/pessoas");
        return modelAndView;
    }

    @Override
    public ModelAndView atualizar(@ModelAttribute Pessoa pessoa) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/pessoas");
        return modelAndView;
    }
}
