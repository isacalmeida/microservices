package br.edu.unoesc.acessoservice.common.model;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ace_acesso")
public class Acesso implements Serializable {

	private static final long serialVersionUID = 1L;

	// == primary-fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ace_id")
    private Long id;
    
    @Column(name = "ace_ler", nullable = false)
    private Boolean ler;

    @Column(name = "ace_criar", nullable = false)
    private Boolean criar;

    @Column(name = "ace_alterar", nullable = false)
    private Boolean alterar;
    
    @Column(name = "ace_remover", nullable = false)
    private Boolean remover;
    
    
    // == extra-fields ==
    @Column(name = "ace_ativo", nullable = false)
    private Boolean ativo = true;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "ace_data_criacao", nullable = false)
    private Date dataCriacao = Calendar.getInstance().getTime();

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "ace_data_alteracao")
    private Date dataAlteracao;
    
    
    // == relations-fields ==
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ace_id_programa", foreignKey = @ForeignKey(name="FK_acesso_programa"))
    private Programa programa;
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ace_id_perfil", foreignKey = @ForeignKey(name="FK_acesso_perfil"))
    private Perfil perfil;
    
}
