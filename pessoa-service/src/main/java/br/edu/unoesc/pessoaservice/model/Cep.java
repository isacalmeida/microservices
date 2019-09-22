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
@Table(name = "cep_cep")
public class Cep {

    // == primary-fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cep_id")
    private Long id;

    @Column(name = "cep_cep", length = 9, nullable = false)
    private String cep;

    @Column(name = "cep_logradouro", length = 100, nullable = false)
    private String logradouro;

    @Column(name = "cep_bairro", length = 50, nullable = false)
    private String bairro;

    @Column(name = "cep_ibge", length = 10, nullable = false)
    private String ibge;


    // == extra-fields ==
    @Column(name = "cep_ativo", nullable = false)
    private Boolean ativo = true;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "cep_data_criacao", nullable = false)
    private Date dataCriacao = Calendar.getInstance().getTime();

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "cep_data_alteracao")
    private Date dataAlteracao;


    // == relations-fields ==
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cep_id_cidade", foreignKey = @ForeignKey(name="FK_cep_cidade"))
    private Cidade cidade;
}
