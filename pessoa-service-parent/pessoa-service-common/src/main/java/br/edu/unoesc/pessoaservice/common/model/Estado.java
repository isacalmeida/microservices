package br.edu.unoesc.pessoaservice.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Estado extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	// == primary-fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;

    @Column(length = 50, nullable = false)
    private String descricao;

    @Column(length = 2, nullable = false)
    private String sigla;

	@Override
	public Long getId() {
		return getIdEstado();
	}

	@Override
	public void setId(Long id) {
		setIdEstado(id);
	}
}
