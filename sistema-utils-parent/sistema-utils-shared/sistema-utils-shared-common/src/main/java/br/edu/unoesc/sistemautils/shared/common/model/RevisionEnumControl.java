package br.edu.unoesc.sistemautils.shared.common.model;

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
public class RevisionEnumControl extends AbstractEntity {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRevisionEnumControl;

    @Column(length = 100, nullable = false)
    private String descricaoEnum;

    @Column(nullable = false)
    private Long revisao;

    @Column(nullable = false)
    private String enumHash;

	@Override
	public Long getId() {
		return getIdRevisionEnumControl();
	}
	
	@Override
	public void setId(Long id) {
		setIdRevisionEnumControl(id);
	}
}
