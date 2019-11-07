package br.edu.unoesc.acessoservice.common.model.enums;

import java.util.Arrays;
import java.util.List;

public enum EnumTipoServico {
    PESSOA("Pessoa"),
    ACESSO("Acesso");

    private String descricao;

    EnumTipoServico(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    public static List<EnumTipoServico> getList(){
        return Arrays.asList(EnumTipoServico.values());
    }
}
