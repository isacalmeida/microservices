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
@ToString(exclude = "pessoa")
@EqualsAndHashCode(callSuper = false)
public class Endereco extends AbstractDetailEntity<Pessoa> {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;

    @Column(length = 10, nullable = false)
    private String numero;

    @Column(length = 100)
    private String complemento;

    @Column(length = 255)
    private String observacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPessoa", foreignKey = @ForeignKey(name = "FK_endereco_pessoa"))
    private Pessoa pessoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCep", foreignKey = @ForeignKey(name="FK_endereco_cep"))
    private Cep cep;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoEndereco", foreignKey = @ForeignKey(name="FK_endereco_tipo_endereco"))
    private TipoEndereco tipoEndereco;

	@Override
	public Long getId() {
		return getIdEndereco();
	}

	@Override
	public void setId(Long id) {
		setIdEndereco(id);
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
