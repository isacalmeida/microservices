package br.edu.unoesc.pessoaservice.model.enums;

import java.util.Arrays;
import java.util.List;

public enum EnumGeneroPessoa {
    HOMEM("Homem"),
    MULHER("Mulher"),
    AMBOS("Ambos"),
    NENHUM("Nenhum");

    private String descricao;

    EnumGeneroPessoa(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    public static List<EnumGeneroPessoa> getList(){
        return Arrays.asList(EnumGeneroPessoa.values());
    }
}
