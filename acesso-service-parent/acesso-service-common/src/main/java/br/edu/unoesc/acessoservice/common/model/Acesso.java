package br.edu.unoesc.acessoservice.common.model;

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

import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractDetailEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "perfil")
@EqualsAndHashCode(callSuper = false)
public class Acesso extends AbstractDetailEntity<Perfil> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAcesso;

	@Column(nullable = false)
	private Boolean ler;

	@Column(nullable = false)
	private Boolean criar;

	@Column(nullable = false)
	private Boolean alterar;

	@Column(nullable = false)
	private Boolean remover;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPrograma", foreignKey = @ForeignKey(name = "FK_acesso_programa"))
	private Programa programa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPerfil", foreignKey = @ForeignKey(name = "FK_acesso_perfil"))
	private Perfil perfil;

	@Override
	public Long getId() {
		return getIdAcesso();
	}

	@Override
	public void setId(Long id) {
		setIdAcesso(id);
	}

	@Override
	public Perfil getMasterEntity() {
		return getPerfil();
	}

	@Override
	public void setMasterEntity(Perfil masterEntity) {
		setPerfil(masterEntity);
	}
}
