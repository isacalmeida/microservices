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
public class Problema extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProblema;

	@Column(length = 255, nullable = false)
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idStatusProblema", foreignKey = @ForeignKey(name = "FK_problema_status"))
	private StatusProblema statusProblema;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idIncidente", foreignKey = @ForeignKey(name = "FK_problema_incidente"))
	private Incidente incidente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idErroConhecido", foreignKey = @ForeignKey(name = "FK_problema_erro_conhecido"))
	private ErroConhecido erroConhecido;

	@Column(length = 500)
	private String resolucao;

	private Long protocoloMudanca;

	@Override
	public Long getId() {
		return getIdProblema();
	}

	@Override
	public void setId(Long id) {
		setIdProblema(id);
	}
}
