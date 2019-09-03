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
public class Cep {

    // == primary-fields ==
    @NotNull
    private Long id;

    @NotNull
    @Max(8)
    private String cep;

    @NotNull
    @Max(100)
    private String logradouro;

    @NotNull
    @Max(50)
    private String bairro;

    @NotNull
    @Max(10)
    private String ibge;


    // == extra-fields ==
    @NotNull
    private Boolean ativo = true;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @NotNull
    private Date dataCriacao = Calendar.getInstance().getTime();

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @NotNull
    private Date dataAlteracao;


    // == relations-fields ==
    @NotNull
    private Cidade cidade;
}
