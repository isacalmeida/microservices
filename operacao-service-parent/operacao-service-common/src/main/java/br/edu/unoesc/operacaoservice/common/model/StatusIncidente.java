package br.edu.unoesc.operacaoservice.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import br.edu.unoesc.sistemautils.arquitetura.common.model.IIdentityEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StatusIncidente implements IIdentityEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	private Long idStatusIncidente;

	@Column(length = 255, nullable = false)
	private String descricao;

	@Override
	public Long getId() {
		return getIdStatusIncidente();
	}

	@Override
	public void setId(Long id) {
		setIdStatusIncidente(id);
	}
}
