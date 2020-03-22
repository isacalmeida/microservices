package br.edu.unoesc.uiservice.web.controller.pessoaservice;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unoesc.pessoaservice.common.model.cep.Cidade;
import br.edu.unoesc.pessoaservice.common.model.cep.Estado;
import br.edu.unoesc.uiservice.api.proxy.PessoaServiceProxy;
import br.edu.unoesc.uiservice.web.controller.utils.DefaultController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        Integer port = proxy.getPortEstadoCidade(estados.get(0).getIdEstado());

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
    	Cidade cidade = proxy.getOneCidade(id);
    	log.info("CIDADE ENVIADA: {}", cidade);
        proxy.deleteCidade(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cidades");
        return modelAndView;
    }

    @Override
    public ModelAndView salvar(@ModelAttribute Cidade cidade){
    	log.info("CIDADE ENVIADA: {}", cidade);
        Cidade cidadeCreated = proxy.createEstadoCidade(cidade.getEstado().getIdEstado(), cidade);
    	log.info("CIDADE SALVA: {}", cidadeCreated);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cidades");
        return modelAndView;
    }

    @Override
    public ModelAndView atualizar(@ModelAttribute Cidade cidade) {
    	log.info("CIDADE ENVIADA: {}", cidade);
        Cidade cidadeUpdated = proxy.updateEstadoCidade(cidade.getEstado().getIdEstado(), cidade.getIdCidade(), cidade);
        log.info("CIDADE SALVA: {}", cidadeUpdated);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cidades");
        return modelAndView;
    }
}