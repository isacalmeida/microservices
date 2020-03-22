package br.edu.unoesc.pessoaservice.common.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_pessoa_juridica_pessoa"))
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Column(name = "razao_social", length = 150)
	private String razaoSocial;

	@Column(name = "nome_fantasia", length = 150)
	private String nomeFantasia;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_fundacao")
	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.DATE)
	private Date dataFundacao;

}
