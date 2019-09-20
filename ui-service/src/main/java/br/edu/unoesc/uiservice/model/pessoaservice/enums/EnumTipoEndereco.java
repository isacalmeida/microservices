package br.edu.unoesc.uiservice.model.pessoaservice.enums;

import java.util.Arrays;
import java.util.List;

public enum EnumTipoEndereco {
    RESIDENCIAL("Residencial"),
    COMERCIAL("Comercial");

    private String descricao;

    EnumTipoEndereco(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    public static List<EnumTipoEndereco> getList(){
        return Arrays.asList(EnumTipoEndereco.values());
    }
}
