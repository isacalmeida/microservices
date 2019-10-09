package br.edu.unoesc.acessoservice.common.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.unoesc.pessoaservice.common.model.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usu_usuario")
public class Usuario {

	// == primary-fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;
    
    
    
    
    
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
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cde_id_estado", foreignKey = @ForeignKey(name="FK_usuario_pessoa"))
    private Pessoa pessoa;
}
