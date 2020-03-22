package br.edu.unoesc.sistemautils.arquitetura.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PersistableEntity extends AuditableEntity {

	@Column(name = "ativo", nullable = false, columnDefinition = "boolean default true")
    private Boolean isAtivo = Boolean.TRUE;
	
	@Column(name = "cancelado", nullable = false, columnDefinition = "boolean default false")
    private Boolean isCancelado = Boolean.FALSE;
	
	@Column(name = "excluido", nullable = false, columnDefinition = "boolean default false")
    private Boolean isExcluido = Boolean.FALSE;

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
