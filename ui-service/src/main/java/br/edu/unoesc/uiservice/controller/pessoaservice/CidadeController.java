package br.edu.unoesc.uiservice.controller.pessoaservice;

import br.edu.unoesc.uiservice.controller.utils.DefaultController;
import br.edu.unoesc.uiservice.model.pessoaservice.Cidade;
import br.edu.unoesc.uiservice.model.pessoaservice.Estado;
import br.edu.unoesc.uiservice.proxy.PessoaServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cidades")
public class CidadeController extends DefaultController<Cidade, PessoaServiceProxy> {

    // == public methods ==
    @Override
    public ModelAndView home(){
        List<Cidade> cidades = proxy.getAllCidade();
        Integer port = proxy.getPortCidade();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cidades", cidades);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("cidades/index");
        return modelAndView;
    }

    @Override
    public ModelAndView novo(){
        List<Estado> estados = proxy.getAllEstado();
        Integer port = proxy.getPortEstadoCidade(estados.get(0).getId());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cidade", new Cidade());
        modelAndView.addObject("estados", estados);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("cidades/novo");
        return modelAndView;
    }

    @Override
    public ModelAndView getOne(@PathVariable Long id){
        List<Estado> estados = proxy.getAllEstado();
        Cidade cidade = proxy.getOneCidade(id);
        Integer port = proxy.getPortCidade();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cidade", cidade);
        modelAndView.addObject("estados", estados);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("cidades/editar");
        return modelAndView;
    }

    @Override
    public ModelAndView excluir(@PathVariable Long id) {
        proxy.deleteCidade(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cidades");
        return modelAndView;
    }

    @Override
    public ModelAndView salvar(@ModelAttribute Cidade cidade){
        Cidade cidadeCreated = proxy.createEstadoCidade(cidade.getEstado().getId(), cidade);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cidades");
        return modelAndView;
    }

    @Override
    public ModelAndView atualizar(@ModelAttribute Cidade cidade) {
        Cidade cidadeUpdated = proxy.updateEstadoCidade(cidade.getEstado().getId(), cidade.getId(), cidade);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cidades");
        return modelAndView;
    }
}