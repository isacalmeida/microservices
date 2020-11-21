package br.edu.unoesc.sistemautils.arquitetura.restapi.common.dto;

import org.springframework.hateoas.RepresentationModel;

public abstract class PersistableDTO<DTO extends RepresentationModel<DTO>> extends AuditableDTO<DTO> {

	private static final long serialVersionUID = 1L;

	private Boolean isAtivo;

	private Boolean isCancelado;

	private Boolean isExcluido;

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Boolean getIsCancelado() {
		return isCancelado;
	}

	public void setIsCancelado(Boolean isCancelado) {
		this.isCancelado = isCancelado;
	}

	public Boolean getIsExcluido() {
		return isExcluido;
	}

	public void setIsExcluido(Boolean isExcluido) {
		this.isExcluido = isExcluido;
	}
}
