package br.edu.unoesc.pessoaservice.common.model.pessoa;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.edu.unoesc.pessoaservice.common.model.enums.EnumGeneroPessoa;
import br.edu.unoesc.pessoaservice.common.model.enums.EnumTipoPessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pes_pessoa")
public class Pessoa {

    // == primary-fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pes_id")
    private Long id;

    @Column(name = "pes_tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumTipoPessoa tipo;


    // == funcionario-fields ==
    @Column(name = "pes_cpf", length = 14)
    private String cpf;

    @Column(name = "pes_nome_completo", length = 100)
    private String nomeCompleto;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    @DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.DATE)
    @Column(name = "pes_data_nascimento", length = 10)
    private Date dataNascimento;

    @Column(name = "pes_genero")
    @Enumerated(EnumType.STRING)
    private EnumGeneroPessoa genero;

    @Column(name = "pes_setor", length = 50)
    private String setor;

    @Column(name = "pes_cargo", length = 50)
    private String cargo;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    @DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.DATE)
    @Column(name = "pes_data_admissao", length = 10)
    private Date dataAdmissao;


    // == cliente-fornecedor-fields ==
    @Column(name = "pes_cnpj", length = 18)
    private String cnpj;

    @Column(name = "pes_razao_social", length = 150)
    private String razaoSocial;

    @Column(name = "pes_nome_fantasia", length = 150)
    private String nomeFantasia;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    @DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.DATE)
    @Column(name = "pes_data_fundacao", length = 10)
    private Date dataFundacao;

    @Column(name = "pes_cliente", nullable = false)
    private Boolean cliente = false;

    @Column(name = "pes_fornecedor", nullable = false)
    private Boolean fornecedor = false;


    // == extra-fields ==
    @Column(name = "pes_ativo", nullable = false)
    private Boolean ativo = true;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "pes_data_criacao", nullable = false)
    private Date dataCriacao = Calendar.getInstance().getTime();

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "pes_data_alteracao")
    private Date dataAlteracao;


    // == relations-fields ==
    @JsonManagedReference
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    private List<Endereco> enderecos;

    @JsonManagedReference
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    private List<Contato> contatos;

}