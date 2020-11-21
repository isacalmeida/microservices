package br.edu.unoesc.acessoservice.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Programa extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrograma;

	@Column(length = 50, nullable = false)
	private String descricao;

	@Column(length = 250, nullable = false)
	private String endereco;

	@Column(length = 7)
	private String sigla;

	@Column(nullable = false)
	private TipoServico tipoServico;

	@Override
	public Long getId() {
		return getIdPrograma();
	}

	@Override
	public void setId(Long id) {
		setIdPrograma(id);
	}
}
