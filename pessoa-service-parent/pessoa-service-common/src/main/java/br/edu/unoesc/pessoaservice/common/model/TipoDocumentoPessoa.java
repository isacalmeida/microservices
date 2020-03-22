package br.edu.unoesc.pessoaservice.common.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractDetailEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TipoDocumentoPessoa extends AbstractDetailEntity<Pessoa> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoDocumentoPessoa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPessoa", foreignKey = @ForeignKey(name = "FK_tipo_documento_pessoa_pessoa"))
	private Pessoa pessoa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoDocumento", foreignKey = @ForeignKey(name = "FK_tipo_documento_pessoa_tipo_documento"))
	private TipoDocumento tipoDocumento;

	@Override
	public Long getId() {
		return getIdTipoDocumentoPessoa();
	}

	@Override
	public void setId(Long id) {
		setIdTipoDocumentoPessoa(id);
	}

	@Override
	public Pessoa getMasterEntity() {
		return getPessoa();
	}

	@Override
	public void setMasterEntity(Pessoa masterEntity) {
		setPessoa(masterEntity);
	}
}
