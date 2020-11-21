package br.edu.unoesc.transicaoservice.common.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractDetailEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "mudanca")
@EqualsAndHashCode(callSuper = false)
public class MudancaItemConfiguracao extends AbstractDetailEntity<Mudanca>{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMudancaItemConfiguracao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMudanca", foreignKey = @ForeignKey(name = "FK_mudancaitemconfiguracao_mudanca"))
	private Mudanca mudanca;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idItemConfiguracao", foreignKey = @ForeignKey(name = "FK_mudancaitemconfiguracao_itemconfiguracao"))
	private ItemConfiguracao itemConfiguracao;

	@Override
	public Mudanca getMasterEntity() {
		return getMudanca();
	}

	@Override
	public void setMasterEntity(Mudanca masterEntity) {
		setMudanca(masterEntity);
	}

	@Override
	public Long getId() {
		return getIdMudancaItemConfiguracao();
	}

	@Override
	public void setId(Long id) {
		setIdMudancaItemConfiguracao(id);
	}
}
