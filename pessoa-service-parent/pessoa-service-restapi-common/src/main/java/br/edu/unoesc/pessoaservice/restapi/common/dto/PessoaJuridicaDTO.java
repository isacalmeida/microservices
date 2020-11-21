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
public class PessoaJuridicaDTO extends PessoaDTO<PessoaJuridicaDTO> {

	private static final long serialVersionUID = 1L;

	private String razaoSocial;

	private String nomeFantasia;

	private Date dataFundacao;
}
