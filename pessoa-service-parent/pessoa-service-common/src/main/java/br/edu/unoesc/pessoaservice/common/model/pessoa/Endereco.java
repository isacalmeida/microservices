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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.unoesc.pessoaservice.common.model.cep.Cep;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoEndereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "end_endereco")
@ToString(exclude = "pessoa")
public class Endereco {

    // == primary-fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "end_id")
    private Long id;

    @Column(name = "end_tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumTipoEndereco tipo;

    @Column(name = "end_numero", length = 10, nullable = false)
    private String numero;

    @Column(name = "end_complemento", length = 100)
    private String complemento;

    @Column(name = "end_observacao", length = 255)
    private String observacao;

    // == extra-fields ==
    @Column(name = "end_ativo", nullable = false)
    private Boolean ativo = true;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "end_data_criacao", nullable = false)
    private Date dataCriacao = Calendar.getInstance().getTime();

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "end_data_alteracao")
    private Date dataAlteracao;


    // == relations-fields ==
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "end_id_pessoa", foreignKey = @ForeignKey(name = "FK_endereco_pessoa"))
    private Pessoa pessoa;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "end_id_cep", foreignKey = @ForeignKey(name="FK_endereco_cep"))
    private Cep cep;

}
