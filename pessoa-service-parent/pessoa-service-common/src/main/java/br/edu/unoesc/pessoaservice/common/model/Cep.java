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
public class Cep extends AbstractEntity {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCep;

    @Column(length = 9, nullable = false)
    private String cep;

    @Column(length = 100, nullable = false)
    private String logradouro;

    @Column(length = 50, nullable = false)
    private String bairro;

    @Column(length = 10, nullable = false)
    private String ibge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCidade", foreignKey = @ForeignKey(name="FK_cep_cidade"))
    private Cidade cidade;

	@Override
	public Long getId() {
		return getIdCep();
	}

	@Override
	public void setId(Long id) {
		setIdCep(id);
	}
}
