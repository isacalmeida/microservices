package br.edu.unoesc.transicaoservice.common.model;

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
public class ItemConfiguracao extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItemConfiguracao;

	@Column(length = 100, nullable = false)
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idItemConfiguracaoSuperior", foreignKey = @ForeignKey(name = "FK_item_configuracao_superior"))
	private ItemConfiguracao itemConfiguracaoSuperior;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idStatusItemConfiguracao", foreignKey = @ForeignKey(name = "FK_item_configuracao_status"))
	private StatusItemConfiguracao statusItemConfiguracao;

	@Column(length = 100, nullable = true)
	private String modelo;

	@Column(length = 100, nullable = true)
	private String numeroSerie;

	@Column(length = 100, nullable = true)
	private String local;

	@Column(length = 500, nullable = true)
	private String observacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCategoriaItemConfiguracao", foreignKey = @ForeignKey(name = "FK_item_configuracao_categoria"))
	private CategoriaItemConfiguracao categoriaItemConfiguracao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoItemConfiguracao", foreignKey = @ForeignKey(name = "FK_item_configuracao_tipo"))
	private TipoItemConfiguracao tipoItemConfiguracao;

	@Column(nullable = true)
	private Long protocoloPessoaResponsavel;

	@Column(nullable = true)
	private Long protocoloPessoaFornecedor;

	@Override
	public Long getId() {
		return getIdItemConfiguracao();
	}

	@Override
	public void setId(Long id) {
		setIdItemConfiguracao(id);
	}
}
