package br.edu.unoesc.transicaoservice.common.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import br.edu.unoesc.sistemautils.arquitetura.common.model.AbstractMasterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Mudanca extends AbstractMasterEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMudanca;

	@Column(length = 255, nullable = false)
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idStatusMudanca", foreignKey = @ForeignKey(name = "FK_mudanca_status"))
	private StatusMudanca statusMudanca;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
	private Date dataProposta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPrioridade", foreignKey = @ForeignKey(name = "FK_mudanca_prioridade"))
	private Prioridade prioridade;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idImpacto", foreignKey = @ForeignKey(name = "FK_mudanca_impacto"))
	private Impacto impacto;

	@Column(nullable = false)
	private Boolean isAutorizado = false;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss", iso = DateTimeFormat.ISO.DATE_TIME)
	private Date dataAutorizacao;

	private Long protocoloPessoa;

	private Long protocoloProblema;

	@Column(length = 500, nullable = false)
	private String atividades;

	@Column(length = 500, nullable = false)
	private String planoRetorno;

	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(mappedBy = "mudanca", cascade = CascadeType.ALL)
	private List<MudancaItemConfiguracao> mudancaItemConfiguracao;

	@Override
	public Long getId() {
		return getIdMudanca();
	}

	@Override
	public void setId(Long id) {
		setIdMudanca(id);
	}
}
