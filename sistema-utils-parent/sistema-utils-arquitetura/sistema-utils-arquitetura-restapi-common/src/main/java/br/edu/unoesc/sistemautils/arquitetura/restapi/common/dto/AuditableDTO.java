package br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto;

import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

public abstract class AuditableDTO<DTO extends RepresentationModel<DTO>> extends AbstractDTO<DTO> {

	private static final long serialVersionUID = 1L;

	private Date dataCriacao;

	private Date dataAlteracao;

	private String usuarioCriacao;

	private String usuarioAlteracao;

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getUsuarioCriacao() {
		return usuarioCriacao;
	}

	public void setUsuarioCriacao(String usuarioCriacao) {
		this.usuarioCriacao = usuarioCriacao;
	}

	public String getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(String usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}
}
