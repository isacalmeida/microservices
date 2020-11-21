package br.edu.unoesc.transicaoservice.common.model;

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
public class Prioridade implements IIdentityEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	private Long idPrioridade;

	@Column(length = 255, nullable = false)
	private String descricao;

	@Override
	public Long getId() {
		return getIdPrioridade();
	}

	@Override
	public void setId(Long id) {
		setIdPrioridade(id);
	}
}
