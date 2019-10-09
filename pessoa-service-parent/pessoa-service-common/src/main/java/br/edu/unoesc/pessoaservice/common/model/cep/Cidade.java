package br.edu.unoesc.pessoaservice.common.model.cep;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cde_cidade")
public class Cidade {

    // == primary-fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cde_id")
    private Long id;

    @Column(name = "cde_descricao", length = 50, nullable = false)
    private String descricao;


    // == extra-fields ==
    @Column(name = "cde_ativo", nullable = false)
    private Boolean ativo = true;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "cde_data_criacao", nullable = false)
    private Date dataCriacao = Calendar.getInstance().getTime();

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "cde_data_alteracao")
    private Date dataAlteracao;


    // == relations-fields ==
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cde_id_estado", foreignKey = @ForeignKey(name="FK_cidade_estado"))
    private Estado estado;
}
