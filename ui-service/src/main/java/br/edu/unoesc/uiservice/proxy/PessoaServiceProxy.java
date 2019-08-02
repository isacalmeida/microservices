package br.edu.unoesc.uiservice.proxy;

import br.edu.unoesc.pessoaservice.model.Pessoa;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "pessoa-service")
public interface PessoaServiceProxy {

    @GetMapping("/pessoa-service/pessoas")
    List<Pessoa> getAll();

    @GetMapping("/pessoa-service/pessoas/{id}")
    Pessoa getOne(@PathVariable Long id);

    @GetMapping("/pessoa-service/pessoas/port")
    Integer getPort();

}
