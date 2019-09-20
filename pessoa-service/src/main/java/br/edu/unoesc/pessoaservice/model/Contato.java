package br.edu.unoesc.pessoaservice.model;

import br.edu.unoesc.pessoaservice.model.enums.EnumTipoContato;
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
@Table(name = "cnt_contato")
public class Contato {

    // == primary-fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cnt_id")
    private Long id;

    @Column(name = "cnt_tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumTipoContato tipo;

    @Column(name = "cnt_descricao", length = 50, nullable = false)
    private String descricao;


    // == extra-fields ==
    @Column(name = "cnt_ativo", nullable = false)
    private Boolean ativo = true;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "cnt_data_criacao", nullable = false)
    private Date dataCriacao = Calendar.getInstance().getTime();

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "cnt_data_alteracao")
    private Date dataAlteracao;


    // == relations-fields ==
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cnt_id_pessoa", foreignKey = @ForeignKey(name = "FK_contato_pessoa"))
    private Pessoa pessoa;
}
