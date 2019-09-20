package br.edu.unoesc.uiservice.controller.utils;

import br.edu.unoesc.uiservice.model.pessoaservice.enums.EnumTipoContato;
import br.edu.unoesc.uiservice.model.pessoaservice.enums.EnumTipoEndereco;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class EnumController {

    // == enums methods ==
    @GetMapping("/tipos/contato")
    @ResponseBody
    public String getTipoContato(){
        StringBuilder result = new StringBuilder();
        result.append("<option value='null'>-- Selecione --</option>");
        for(EnumTipoContato option : EnumTipoContato.getList()) {
            result.append("<option value='").append(option).append("'>").append(option.getDescricao()).append("</option>");
        }
        return result.toString();
    }

    @GetMapping("/tipos/endereco")
    @ResponseBody
    public String getTipoEndereco(){
        StringBuilder result = new StringBuilder();
        result.append("<option value='null'>-- Selecione --</option>");
        for(EnumTipoEndereco option : EnumTipoEndereco.getList()) {
            result.append("<option value='").append(option).append("'>").append(option.getDescricao()).append("</option>");
        }
        return result.toString();
    }
}
