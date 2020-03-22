package br.edu.unoesc.pessoaservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.pessoaservice.common.model.TipoPessoa;
import br.edu.unoesc.sistemautils.arquitetura.common.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.IRevisao;

public enum EnumTipoPessoa implements IRevisao, IEnumEntidade<TipoPessoa> {
	
	PESSOA_FISICA(new TipoPessoa(1L, "Pessoa Fisica")),
	PESSOA_JURIDICA(new TipoPessoa(2L, "Pessoa Juridica")),
	;

	private TipoPessoa entidade;

	EnumTipoPessoa(TipoPessoa entidade){
		this.entidade = entidade;
	}

	@Override
	public TipoPessoa getEntidade() {
		return entidade;
	}

	@Override
	public Long getRevisao() {
		return 0L;
	}

	public static List<EnumTipoPessoa> getList() {
		return Arrays.asList(values());
	}

	public static List<TipoPessoa> getListEntidade() {
		List<TipoPessoa> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
