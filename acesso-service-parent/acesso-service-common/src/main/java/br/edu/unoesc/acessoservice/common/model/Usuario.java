package br.edu.unoesc.acessoservice.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Usuario extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@Column(length = 50, nullable = false)
	private String login;

	@Column(length = 250, nullable = false)
	private String senha;

	@Column(nullable = false)
	private Long protocoloPessoa;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPerfil", foreignKey = @ForeignKey(name = "FK_usuario_perfil"))
	private Perfil perfil;

	@Override
	public Long getId() {
		return getIdUsuario();
	}

	@Override
	public void setId(Long id) {
		setIdUsuario(id);
	}
}
