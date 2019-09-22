package br.edu.unoesc.pessoaservice.model;

import br.edu.unoesc.pessoaservice.model.enums.EnumTipoEndereco;
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
@Table(name = "end_endereco")
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

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "end_data_criacao", nullable = false)
    private Date dataCriacao = Calendar.getInstance().getTime();

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "end_data_alteracao")
    private Date dataAlteracao;


    // == relations-fields ==
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "end_id_pessoa", foreignKey = @ForeignKey(name = "FK_endereco_pessoa"))
    private Pessoa pessoa;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "end_id_cep", foreignKey = @ForeignKey(name="FK_endereco_cep"))
    private Cep cep;

}
