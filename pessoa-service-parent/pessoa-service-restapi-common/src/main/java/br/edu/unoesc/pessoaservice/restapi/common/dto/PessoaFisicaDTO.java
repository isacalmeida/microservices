package br.edu.unoesc.pessoaservice.restapi.common.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PessoaFisicaDTO extends PessoaDTO<PessoaFisicaDTO> {

	private static final long serialVersionUID = 1L;

	private String nomeCompleto;

	private String setor;

	private String cargo;

	private Date dataNascimento;

	private Date dataAdmissao;

	private GeneroPessoaDTO generoPessoa;
}
