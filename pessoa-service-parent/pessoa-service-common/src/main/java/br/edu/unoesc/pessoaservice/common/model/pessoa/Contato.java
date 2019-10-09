package br.edu.unoesc.pessoaservice.common.model.pessoa;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoContato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cnt_contato")
@ToString(exclude = "pessoa")
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

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "cnt_data_criacao", nullable = false)
    private Date dataCriacao = Calendar.getInstance().getTime();

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "cnt_data_alteracao")
    private Date dataAlteracao;


    // == relations-fields ==
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cnt_id_pessoa", foreignKey = @ForeignKey(name = "FK_contato_pessoa"))
    private Pessoa pessoa;
}
