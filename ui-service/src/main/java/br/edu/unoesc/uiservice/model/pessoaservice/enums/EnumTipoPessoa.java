package br.edu.unoesc.uiservice.model.pessoaservice.enums;

import java.util.Arrays;
import java.util.List;

public enum EnumTipoPessoa {
    FISICA("Pessoa Física"),
    JURIDICA("Pessoa Jurídica");

    public final String descricao;

    EnumTipoPessoa(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    public static List<EnumTipoPessoa> getList(){
        return Arrays.asList(EnumTipoPessoa.values());
    }
}
