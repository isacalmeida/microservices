package br.edu.unoesc.pessoaservice.common.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_pessoa_fisica_pessoa"))
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Column(length = 100)
	private String nomeCompleto;

	@Column(length = 50)
	private String setor;

	@Column(length = 50)
	private String cargo;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.DATE)
	private Date dataNascimento;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.DATE)
	private Date dataAdmissao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idGeneroPessoa", foreignKey = @ForeignKey(name = "FK_pessoa_fisica_genero_pessoa"))
	private GeneroPessoa generoPessoa;
}
