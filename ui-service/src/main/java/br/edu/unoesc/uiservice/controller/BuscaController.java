package br.edu.unoesc.uiservice.controller;

import br.edu.unoesc.uiservice.model.pessoaservice.Cidade;
import br.edu.unoesc.uiservice.proxy.PessoaServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseEntity buscaCidade(@RequestBody Cidade cidade){
        String sigla = cidade.getEstado().getSigla();
        String descricao = cidade.getDescricao();

        List<Cidade> cidadeFind = pessoaServiceProxy.getOneCidadeBySiglaAndDescricao(sigla, descricao);

        if(cidadeFind != null)
            return ResponseEntity.ok(cidadeFind);
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
