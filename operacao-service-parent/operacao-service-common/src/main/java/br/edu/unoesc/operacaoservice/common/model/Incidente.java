package br.edu.unoesc.operacaoservice.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Incidente extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIncidente;

	@Column(length = 255, nullable = false)
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idStatusIncidente", foreignKey = @ForeignKey(name = "FK_incidente_status"))
	private StatusIncidente statusIncidente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPrioridade", foreignKey = @ForeignKey(name = "FK_incidente_prioridade"))
	private Prioridade prioridade;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idImpacto", foreignKey = @ForeignKey(name = "FK_incidente_impacto"))
	private Impacto impacto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEvento", foreignKey = @ForeignKey(name = "FK_incidente_evento"))
	private Evento evento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRequisicao", foreignKey = @ForeignKey(name = "FK_incidente_requisicao"))
	private Requisicao requisicao;

	@Column(length = 500, nullable = false)
	private String resolucao;

	private Long protocoloItemConfiguracao;

	@Override
	public Long getId() {
		return getIdIncidente();
	}

	@Override
	public void setId(Long id) {
		setIdIncidente(id);
	}
}
