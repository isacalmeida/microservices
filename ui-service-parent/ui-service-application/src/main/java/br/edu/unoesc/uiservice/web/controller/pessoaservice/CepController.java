package br.edu.unoesc.uiservice.web.controller.pessoaservice;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unoesc.pessoaservice.common.model.cep.Cep;
import br.edu.unoesc.pessoaservice.common.model.cep.Cidade;
import br.edu.unoesc.uiservice.api.proxy.PessoaServiceProxy;
import br.edu.unoesc.uiservice.web.controller.utils.DefaultController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
    	Cep cep = proxy.getOneCep(id);
        log.info("CEP ENVIADO: {}", cep);
    	proxy.deleteCep(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ceps");
        return modelAndView;
    }

    @Override
    public ModelAndView salvar(@ModelAttribute Cep cep){
        log.info("CEP ENVIADO: {}", cep);
        Cidade cidade = proxy.getOneCidade(cep.getCidade().getIdCidade());
        cep.setCidade(cidade);
        Cep cepCreated = proxy.createEstadoCidadeCep(cep.getCidade().getEstado().getIdEstado(), cep.getCidade().getIdCidade(), cep);
        log.info("CEP SALVO: {}", cepCreated);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ceps");
        return modelAndView;
    }

    @Override
    public ModelAndView atualizar(@ModelAttribute Cep cep) {
        log.info("CEP ENVIADO: {}", cep);
        Cidade cidade = proxy.getOneCidade(cep.getCidade().getIdCidade());
        cep.setCidade(cidade);
        Cep cepUpdated = proxy.updateEstadoCidadeCep(cep.getCidade().getEstado().getIdEstado(), cep.getCidade().getIdCidade(), cep.getIdCep(), cep);
        log.info("CEP SALVO: {}", cepUpdated);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/ceps");
        return modelAndView;
    }
}
