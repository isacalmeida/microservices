package br.edu.unoesc.pessoaservice.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import br.edu.unoesc.sistemautils.arquitetura.common.IIdentityEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TipoEndereco implements IIdentityEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	private Long idTipoEndereco;

	@Column(length = 255, nullable = false)
	private String descricao;

	@Override
	public Long getId() {
		return getIdTipoEndereco();
	}

	@Override
	public void setId(Long id) {
		setIdTipoEndereco(id);
	}
}
