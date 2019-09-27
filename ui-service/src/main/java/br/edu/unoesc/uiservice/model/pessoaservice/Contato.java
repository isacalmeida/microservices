package br.edu.unoesc.uiservice.model.pessoaservice;

import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.unoesc.uiservice.model.pessoaservice.enums.EnumTipoContato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "pessoa")
public class Contato {

    // == primary-fields ==
    @NotNull
    private Long id;

    @NotNull
    private EnumTipoContato tipo;

    @NotNull
    @Max(50)
    private String descricao;


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
    @NotNull
    @JsonBackReference
    private Pessoa pessoa;
}
