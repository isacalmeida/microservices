package br.edu.unoesc.uiservice.model.pessoaservice.enums;

import java.util.Arrays;
import java.util.List;

public enum EnumTipoContato {
    EMAIL("E-mail"),
    CELULAR("Celular"),
    TELEFONE_FIXO("Telefone Fixo"),
    WHATSAPP("Whatsapp");

    private String descricao;

    EnumTipoContato(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

    public static List<EnumTipoContato> getList(){
        return Arrays.asList(EnumTipoContato.values());
    }
}
