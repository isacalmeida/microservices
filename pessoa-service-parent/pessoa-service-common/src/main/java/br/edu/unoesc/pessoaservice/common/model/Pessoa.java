package br.edu.unoesc.pessoaservice.common.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import br.edu.unoesc.sistemautils.arquitetura.common.AbstractMasterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa extends AbstractMasterEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoa;

	@Column(nullable = false)
	private Boolean isCliente = false;

	@Column(nullable = false)
	private Boolean isFornecedor = false;

	@Column(nullable = false)
	private Boolean isFuncionario = false;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Endereco> enderecos;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Contato> contatos;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<TipoDocumentoPessoa> tipoDocumentoPessoa;

	@Override
	public Long getId() {
		return getIdPessoa();
	}

	@Override
	public void setId(Long id) {
		setIdPessoa(id);
	}
}
