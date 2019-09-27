package br.edu.unoesc.pessoaservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "est_estado")
public class Estado {

    // == primary-fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "est_id")
    private Long id;

    @Column(name = "est_descricao", length = 50, nullable = false)
    private String descricao;

    @Column(name = "est_sigla", length = 2, nullable = false)
    private String sigla;


    // == extra-fields ==
    @Column(name = "est_ativo", nullable = false)
    private Boolean ativo = true;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "est_data_criacao", nullable = false)
    private Date dataCriacao = Calendar.getInstance().getTime();

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "est_data_alteracao")
    private Date dataAlteracao;

}
