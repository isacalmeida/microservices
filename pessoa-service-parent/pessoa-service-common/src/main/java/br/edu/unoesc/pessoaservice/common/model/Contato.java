package br.edu.unoesc.pessoaservice.common.model;

import javax.persistence.Column;
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
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "pessoa")
@EqualsAndHashCode(callSuper = false)
public class Contato extends AbstractDetailEntity<Pessoa> {

	private static final long serialVersionUID = 1L;

	// == primary-fields ==
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContato;

    @Column(length = 100, nullable = false)
    private String descricao;

    // == relations-fields ==
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoContato", foreignKey = @ForeignKey(name = "FK_contato_tipo_contato"))
    private TipoContato tipoContato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPessoa", foreignKey = @ForeignKey(name = "FK_contato_pessoa"))
    private Pessoa pessoa;

	@Override
	public Long getId() {
		return getIdContato();
	}

	@Override
	public void setId(Long id) {
		setIdContato(id);
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
