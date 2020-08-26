package br.edu.unoesc.sistemautils.shared.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.unoesc.sistemautils.arquitetura.common.model.IIdentityEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RevisionEnumControl implements IIdentityEntity<Long> {

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
