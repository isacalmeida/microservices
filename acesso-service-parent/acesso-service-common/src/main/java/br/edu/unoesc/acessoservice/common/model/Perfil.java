package br.edu.unoesc.acessoservice.common.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractMasterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Perfil extends AbstractMasterEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPerfil;

	@Column(length = 50, nullable = false)
	private String descricao;

	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL)
	private List<Acesso> acessos;

	@Override
	public Long getId() {
		return getIdPerfil();
	}

	@Override
	public void setId(Long id) {
		setIdPerfil(id);
	}
}
