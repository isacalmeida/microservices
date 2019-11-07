package br.edu.unoesc.uiservice.web.controller.utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.unoesc.acessoservice.common.model.enums.EnumTipoServico;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoContato;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoEndereco;

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

    @GetMapping("/tipos/servico")
    @ResponseBody
    public String getTipoServico(){
        StringBuilder result = new StringBuilder();
        result.append("<option value='null'>-- Selecione --</option>");
        for(EnumTipoServico option : EnumTipoServico.getList()) {
            result.append("<option value='").append(option).append("'>").append(option.getDescricao()).append("</option>");
        }
        return result.toString();
    }
}
