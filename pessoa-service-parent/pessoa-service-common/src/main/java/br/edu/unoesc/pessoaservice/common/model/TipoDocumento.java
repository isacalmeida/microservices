package br.edu.unoesc.pessoaservice.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.unoesc.sistemautils.arquitetura.common.IIdentityEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TipoDocumento implements IIdentityEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	private Long idTipoDocumento;

	@Column(length = 255, nullable = false)
	private String descricao;

	private Long caracteres;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoPessoa", foreignKey = @ForeignKey(name = "FK_tipo_documento_tipo_pessoa"))
	private TipoPessoa tipoPessoa;

	@Override
	public Long getId() {
		return getIdTipoDocumento();
	}

	@Override
	public void setId(Long id) {
		setIdTipoDocumento(id);
	}
}
