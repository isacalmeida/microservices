package br.edu.unoesc.uiservice.api.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.edu.unoesc.pessoaservice.common.model.cep.Cep;
import br.edu.unoesc.pessoaservice.common.model.cep.Cidade;
import br.edu.unoesc.pessoaservice.common.model.cep.Estado;
import br.edu.unoesc.pessoaservice.common.model.pessoa.Contato;
import br.edu.unoesc.pessoaservice.common.model.pessoa.Endereco;
import br.edu.unoesc.pessoaservice.common.model.pessoa.Pessoa;

@FeignClient("zuul-server")
@RibbonClient("pessoa-service")
public interface PessoaServiceProxy{

    // == Proxy REST de Pessoas
    @GetMapping("/pessoa-service/pessoas")
    List<Pessoa> getAllPessoa();

    @GetMapping("/pessoa-service/pessoas/{idPessoa}")
    Pessoa getOnePessoa(@PathVariable Long idPessoa);

    @PostMapping("/pessoa-service/pessoas")
    Pessoa createPessoa(@ModelAttribute Pessoa pessoa);

    @PutMapping("/pessoa-service/pessoas/{idPessoa}")
    Pessoa updatePessoa(@PathVariable Long idPessoa, @ModelAttribute Pessoa pessoa);

    @DeleteMapping("/pessoa-service/pessoas/{idPessoa}")
    void deletePessoa(@PathVariable Long idPessoa);

    @GetMapping("/pessoa-service/pessoas/port")
    Integer getPortPessoa();


    // == Proxy REST de Pessoas/Contatos
    @GetMapping("/pessoa-service/pessoas/{idPessoa}/contatos")
    List<Contato> getAllPessoaContato(@PathVariable Long idPessoa);

    @GetMapping("/pessoa-service/pessoas/{idPessoa}/contatos/{idContato}")
    Contato getOnePessoaContato(@PathVariable Long idPessoa, @PathVariable Long idContato);

    @GetMapping("/pessoa-service/pessoas/{idPessoa}/contatos/port")
    Integer getPortPessoaContato(@PathVariable Long idPessoa);


    // == Proxy REST de Pessoas/Enderecos
    @GetMapping("/pessoa-service/pessoas/{idPessoa}/enderecos")
    List<Endereco> getAllPessoaEndereco(@PathVariable Long idPessoa);

    @GetMapping("/pessoa-service/pessoas/{idPessoa}/enderecos/{idEndereco}")
    Endereco getOnePessoaEndereco(@PathVariable Long idPessoa, @PathVariable Long idEndereco);

    @GetMapping("/pessoa-service/pessoas/{idPessoa}/enderecos/port")
    Integer getPortPessoaEndereco(@PathVariable Long idPessoa);


    // == Proxy REST de Pessoas/Enderecos/Ceps
    @GetMapping("/pessoa-service/pessoas/{idPessoa}/enderecos/{idEndereco}/ceps")
    List<Cep> getAllPessoaEnderecoCep(@PathVariable Long idPessoa, @PathVariable Long idEndereco);

    @GetMapping("/pessoa-service/pessoas/{idPessoa}/enderecos/{idEndereco}/ceps/{idCep}")
    Cep getOnePessoaEnderecoCep(@PathVariable Long idPessoa, @PathVariable Long idEndereco, @PathVariable Long idCep);

    @GetMapping("/pessoa-service/pessoas/{idPessoa}/enderecos/{idEndereco}/ceps/port")
    Integer getPortPessoaEnderecoCep(@PathVariable Long idPessoa, @PathVariable Long idEndereco);


    // == Proxy REST de Estado
    @GetMapping("/pessoa-service/estados")
    List<Estado> getAllEstado();

    @GetMapping("/pessoa-service/estados/{idEstado}")
    Estado getOneEstado(@PathVariable Long idEstado);

    @PostMapping("/pessoa-service/estados")
    Estado createEstado(Estado estado);

    @PutMapping("/pessoa-service/estados/{idEstado}")
    Estado updateEstado(@PathVariable Long idEstado, Estado estado);

    @DeleteMapping("/pessoa-service/estados/{idEstado}")
    void deleteEstado(@PathVariable Long idEstado);

    @GetMapping("/pessoa-service/estados/port")
    Integer getPortEstado();


    // == Proxy REST de Cidade
    @GetMapping("/pessoa-service/cidades")
    List<Cidade> getAllCidade();

    @GetMapping("/pessoa-service/cidades/{idCidade}")
    Cidade getOneCidade(@PathVariable Long idCidade);

    @PostMapping("/pessoa-service/cidades")
    Cidade createCidade(Cidade cidade);

    @PutMapping("/pessoa-service/cidades/{idCidade}")
    Cidade updateCidade(@PathVariable Long idCidade, Cidade cidade);

    @DeleteMapping("/pessoa-service/cidades/{idCidade}")
    void deleteCidade(@PathVariable Long idCidade);

    @GetMapping("/pessoa-service/cidades/port")
    Integer getPortCidade();


    // == Proxy REST de Cep
    @GetMapping("/pessoa-service/ceps")
    List<Cep> getAllCep();

    @GetMapping("/pessoa-service/ceps/{query}/query")
    List<Cep> getAllCepAutocompleteCep(@PathVariable String query);

    @GetMapping("/pessoa-service/ceps/{idCeps}")
    Cep getOneCep(@PathVariable Long idCeps);

    @PostMapping("/pessoa-service/ceps")
    Cep createCep(Cep cep);

    @PutMapping("/pessoa-service/ceps/{idCeps}")
    Cep updateCep(@PathVariable Long idCeps, Cep cep);

    @DeleteMapping("/pessoa-service/ceps/{idCeps}")
    void deleteCep(@PathVariable Long idCeps);

    @GetMapping("/pessoa-service/ceps/port")
    Integer getPortCep();


    // == Proxy REST de Estado/Cidade
    @GetMapping("/pessoa-service/estados/{idEstado}/cidades")
    List<Cidade> getAllEstadoCidade(@PathVariable Long idEstado);

    @GetMapping("/pessoa-service/estados/{idEstado}/cidades/{idCidade}")
    Cidade getOneEstadoCidade(@PathVariable Long idEstado, @PathVariable Long idCidade);

    @PostMapping("/pessoa-service/estados/{idEstado}/cidades")
    Cidade createEstadoCidade(@PathVariable Long idEstado, Cidade cidade);

    @PutMapping("/pessoa-service/estados/{idEstado}/cidades/{idCidade}")
    Cidade updateEstadoCidade(@PathVariable Long idEstado, @PathVariable Long idCidade, Cidade cidade);

    @DeleteMapping("/pessoa-service/estados/{idEstado}/cidades/{idCidade}")
    void deleteEstadoCidade(@PathVariable Long idEstado, @PathVariable Long idCidade);

    @GetMapping("/pessoa-service/estados/{idEstado}/cidades/port")
    Integer getPortEstadoCidade(@PathVariable Long idEstado);

    @GetMapping("/pessoa-service/estados/sigla/{sigla}/cidades/descricao/{descricao}")
    List<Cidade> getOneCidadeBySiglaAndDescricao(@PathVariable String sigla, @PathVariable String descricao);


    // == Proxy REST de Estado/Cidade/Cep
    @GetMapping("/pessoa-service/estados/{idEstado}/cidades/{idCidade}/ceps")
    List<Cep> getAllEstadoCidadeCep(@PathVariable Long idEstado, @PathVariable Long idCidade);

    @GetMapping("/pessoa-service/estados/{idEstado}/cidades/{idCidade}/ceps/{idCep}")
    Cep getOneEstadoCidadeCep(@PathVariable Long idEstado, @PathVariable Long idCidade, @PathVariable Long idCep);

    @PostMapping("/pessoa-service/estados/{idEstado}/cidades/{idCidade}/ceps")
    Cep createEstadoCidadeCep(@PathVariable Long idEstado, @PathVariable Long idCidade, Cep cep);

    @PutMapping("/pessoa-service/estados/{idEstado}/cidades/{idCidade}/ceps/{idCep}")
    Cep updateEstadoCidadeCep(@PathVariable Long idEstado, @PathVariable Long idCidade, @PathVariable Long idCep, Cep cep);

    @DeleteMapping("/pessoa-service/estados/{idEstado}/cidades/{idCidade}/ceps/{idCep}")
    void deleteEstadoCidadeCep(@PathVariable Long idEstado, @PathVariable Long idCidade, @PathVariable Long idCep);

    @GetMapping("/pessoa-service/estados/{idEstado}/cidades/{idCidade}/ceps/port")
    Integer getPortEstadoCidadeCep(@PathVariable Long idEstado, @PathVariable Long idCidade);

}
