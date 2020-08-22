package br.edu.unoesc.pessoaservice.common.model;

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
public class Cidade extends AbstractEntity {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCidade;

    @Column(length = 50, nullable = false)
    private String descricao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEstado", foreignKey = @ForeignKey(name="FK_cidade_estado"))
    private Estado estado;

	@Override
	public Long getId() {
		return getIdCidade();
	}

	@Override
	public void setId(Long id) {
		setIdCidade(id);
	}
}
