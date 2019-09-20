package br.edu.unoesc.uiservice.model.pessoaservice;

import br.edu.unoesc.uiservice.model.pessoaservice.enums.EnumGeneroPessoa;
import br.edu.unoesc.uiservice.model.pessoaservice.enums.EnumTipoPessoa;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    // == primary-fields ==
    @NotNull
    private Long id;

    @NotNull
    private EnumTipoPessoa tipo;


    // == funcionario-fields ==
    @Max(11)
    private String cpf;

    @Max(100)
    private String nomeCompleto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.DATE)
    private Date dataNascimento;

    private EnumGeneroPessoa genero;

    @Max(50)
    private String setor;

    @Max(50)
    private String cargo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.DATE)
    private Date dataAdmissao;


    // == cliente-fornecedor-fields ==
    @Max(18)
    private String cnpj;

    @Max(150)
    private String razaoSocial;

    @Max(150)
    private String nomeFantasia;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.DATE)
    private Date dataFundacao;

    @NotNull
    private Boolean cliente = false;

    @NotNull
    private Boolean fornecedor = false;


    // == extra-fields ==
    @NotNull
    private Boolean ativo = true;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull
    private Date dataCriacao = Calendar.getInstance().getTime();

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull
    private Date dataAlteracao;


    // == relations-fields ==
    @NotEmpty
    private List<Endereco> enderecos;

    @NotEmpty
    private List<Contato> contatos;

}
