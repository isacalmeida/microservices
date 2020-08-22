package br.edu.unoesc.pessoaservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.pessoaservice.common.model.TipoDocumento;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IRevisao;

public enum EnumTipoDocumento implements IRevisao, IEnumEntidade<TipoDocumento> {

	CPF(new TipoDocumento(1L, "CPF", 11L, EnumTipoPessoa.PESSOA_FISICA.getEntidade())), 
	CNPJ(new TipoDocumento(2L, "CNPJ", 18L, EnumTipoPessoa.PESSOA_JURIDICA.getEntidade())), 
	RG(new TipoDocumento(3L, "RG", 11L, EnumTipoPessoa.PESSOA_FISICA.getEntidade())), 
	;

	private TipoDocumento entidade;

	private EnumTipoDocumento(TipoDocumento entidade) {
		this.entidade = entidade;
	}

	@Override
	public TipoDocumento getEntidade() {
		return entidade;
	}

	@Override
	public Long getRevisao() {
		return 0L;
	}

	public static List<EnumTipoDocumento> getList() {
		return Arrays.asList(values());
	}

	public static List<TipoDocumento> getListEntidade() {
		List<TipoDocumento> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
