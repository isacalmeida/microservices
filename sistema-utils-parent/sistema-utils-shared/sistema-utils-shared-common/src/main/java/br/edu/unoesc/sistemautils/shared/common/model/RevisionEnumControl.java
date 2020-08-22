package br.edu.unoesc.sistemautils.shared.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractEntity;

@Entity
public class RevisionEnumControl extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	// == primary-fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRevisionEnumControl;

    @Column(length = 100, nullable = false)
    private String descricaoEnum;

    @Column(nullable = false)
    private Long revisao;

    @Column(nullable = false)
    private String enumHash;

    public RevisionEnumControl() {
    }

	public RevisionEnumControl(Long idRevisionEnumControl, String descricaoEnum, Long revisao) {
		this.idRevisionEnumControl = idRevisionEnumControl;
		this.descricaoEnum = descricaoEnum;
		this.revisao = revisao;
	}

	@Override
	public Long getId() {
		return getIdRevisionEnumControl();
	}
	
	@Override
	public void setId(Long id) {
		setIdRevisionEnumControl(id);
	}

	public Long getIdRevisionEnumControl() {
		return idRevisionEnumControl;
	}

	public void setIdRevisionEnumControl(Long idRevisionEnumControl) {
		this.idRevisionEnumControl = idRevisionEnumControl;
	}

	public String getDescricaoEnum() {
		return descricaoEnum;
	}

	public void setDescricaoEnum(String descricaoEnum) {
		this.descricaoEnum = descricaoEnum;
	}

	public Long getRevisao() {
		return revisao;
	}

	public void setRevisao(Long revisao) {
		this.revisao = revisao;
	}

	public String getEnumHash() {
		return enumHash;
	}

	public void setEnumHash(String enumHash) {
		this.enumHash = enumHash;
	}
}
