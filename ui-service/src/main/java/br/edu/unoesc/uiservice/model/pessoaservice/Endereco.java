package br.edu.unoesc.uiservice.model.pessoaservice;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    // == primary-fields ==
    @NotNull
    private Long id;

    @NotNull
    @Max(2)
    private Character tipo;

    @NotNull
    @Max(10)
    private String numero;

    @Max(100)
    private String complemento;

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
    private Pessoa pessoa;

    @NotNull
    private Cep cep;

}
