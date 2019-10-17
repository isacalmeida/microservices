package br.edu.unoesc.uiservice.web.controller.pessoaservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unoesc.pessoaservice.common.model.enums.EnumGeneroPessoa;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoPessoa;
import br.edu.unoesc.pessoaservice.common.model.pessoa.Contato;
import br.edu.unoesc.pessoaservice.common.model.pessoa.Endereco;
import br.edu.unoesc.pessoaservice.common.model.pessoa.Pessoa;
import br.edu.unoesc.uiservice.api.proxy.PessoaServiceProxy;
import br.edu.unoesc.uiservice.web.controller.utils.DefaultController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        log.info("PESSOA ENVIADA: {}", pessoa);
        proxy.deletePessoa(pessoa.getId());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/pessoas");
        return modelAndView;
    }

    @Override
    public ModelAndView salvar(@ModelAttribute Pessoa pessoa){
        log.info("PESSOA ENVIADA: {}", pessoa);
        for(Endereco endereco : pessoa.getEnderecos()) {
        	endereco.setPessoa(pessoa);
        }
        for(Contato contato : pessoa.getContatos()) {
        	contato.setPessoa(pessoa);
        }
        Pessoa pessoaCreated = proxy.createPessoa(pessoa);
        log.info("PESSOA SALVA: {}", pessoaCreated);
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/pessoas");
        return modelAndView;
    }

    @Override
    public ModelAndView atualizar(@ModelAttribute Pessoa pessoa) {
    	log.info("PESSOA ENVIADA: {}", pessoa);
    	
    	List<Contato> contatos = new ArrayList<>();
    	List<Endereco> enderecos = new ArrayList<>();
    	
    	pessoa.getContatos().forEach(contato -> {
    		if(contato.getTipo() != null) {
    			contatos.add(contato);
    		}
    	});
    	pessoa.getEnderecos().forEach(endereco -> {
    		if(endereco.getTipo() != null) {
    			enderecos.add(endereco);
    		}
    	});
    	
    	pessoa.setContatos(contatos);
    	pessoa.setEnderecos(enderecos);
        
    	Pessoa pessoaUpdated = proxy.updatePessoa(pessoa.getId(), pessoa);
        log.info("PESSOA SALVA: {}", pessoaUpdated);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/pessoas");
        return modelAndView;
    }
}
