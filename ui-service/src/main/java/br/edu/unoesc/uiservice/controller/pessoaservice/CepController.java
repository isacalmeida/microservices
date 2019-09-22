package br.edu.unoesc.uiservice.controller.pessoaservice;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unoesc.uiservice.controller.utils.DefaultController;
import br.edu.unoesc.uiservice.model.pessoaservice.Cep;
import br.edu.unoesc.uiservice.model.pessoaservice.Cidade;
import br.edu.unoesc.uiservice.proxy.PessoaServiceProxy;

@Controller
@RequestMapping("/ceps")
public class CepController extends DefaultController<Cep, PessoaServiceProxy> {

    // == public methods ==
    @Override
    public ModelAndView home(){
        List<Cep> ceps = proxy.getAllCep();
        Integer port = proxy.getPortCep();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ceps", ceps);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("ceps/index");
        return modelAndView;
    }

    @Override
    public ModelAndView novo(){
        List<Cidade> cidades = proxy.getAllCidade();
        Integer port = proxy.getPortCep();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cep", new Cep());
        modelAndView.addObject("cidades", cidades);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("ceps/novo");
        return modelAndView;
    }

    @Override
    public ModelAndView getOne(@PathVariable Long id){
        List<Cidade> cidades = proxy.getAllCidade();
        Cep cep = proxy.getOneCep(id);
        Integer port = proxy.getPortCep();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cep", cep);
        modelAndView.addObject("cidades", cidades);
        modelAndView.addObject("port", port);
        modelAndView.setViewName("ceps/editar");
        return modelAndView;
    }

    @Override
    public ModelAndView excluir(@PathVariable Long id) {
        proxy.deleteCep(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ceps");
        return modelAndView;
    }

    @Override
    public ModelAndView salvar(@ModelAttribute Cep cep){
        Cidade cidade = proxy.getOneCidade(cep.getCidade().getId());
        cep.setCidade(cidade);
        Cep cepCreated = proxy.createEstadoCidadeCep(cep.getCidade().getEstado().getId(), cep.getCidade().getId(), cep);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ceps");
        return modelAndView;
    }

    @Override
    public ModelAndView atualizar(@ModelAttribute Cep cep) {
        Cidade cidade = proxy.getOneCidade(cep.getCidade().getId());
        cep.setCidade(cidade);
        Cep cepUpdated = proxy.updateEstadoCidadeCep(cep.getCidade().getEstado().getId(), cep.getCidade().getId(), cep.getId(), cep);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ceps");
        return modelAndView;
    }
}
