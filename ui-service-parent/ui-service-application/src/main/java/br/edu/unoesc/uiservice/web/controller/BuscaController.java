package br.edu.unoesc.uiservice.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.pessoaservice.common.model.cep.Cep;
import br.edu.unoesc.pessoaservice.common.model.cep.Cidade;
import br.edu.unoesc.uiservice.api.proxy.PessoaServiceProxy;

@RestController
@RequestMapping("/busca")
public class BuscaController {

    // == fields ==
    private PessoaServiceProxy pessoaServiceProxy;

    // == constructors ==
    @Autowired
    public BuscaController(PessoaServiceProxy pessoaServiceProxy){
        this.pessoaServiceProxy = pessoaServiceProxy;
    }

    @PostMapping("/cidade")
    public ResponseEntity<List<Cidade>> buscaCidade(@RequestBody Cidade cidade){
        String sigla = cidade.getEstado().getSigla();
        String descricao = cidade.getDescricao();

        List<Cidade> cidadeFind = pessoaServiceProxy.getOneCidadeBySiglaAndDescricao(sigla, descricao);

        if(cidadeFind != null) {
            return ResponseEntity.ok(cidadeFind);
        }
		return ResponseEntity.notFound().build();
    }

    @GetMapping("/cep")
    public ResponseEntity<List<Cep>> buscaCep(@RequestParam String query){
        List<Cep> cepFind = pessoaServiceProxy.getAllCepAutocompleteCep(query);

        if(cepFind != null){
            return ResponseEntity.ok(cepFind);
        }
		return ResponseEntity.notFound().build();
    }
}
