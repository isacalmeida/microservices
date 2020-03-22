package br.edu.unoesc.pessoaservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.pessoaservice.common.model.TipoEndereco;
import br.edu.unoesc.sistemautils.arquitetura.common.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.IRevisao;

public enum EnumTipoEndereco implements IRevisao, IEnumEntidade<TipoEndereco> {

	RESIDENCIAL(new TipoEndereco(1L, "Residencial")),
	COMERCIAL(new TipoEndereco(2L, "Comercial")),
	;

	private TipoEndereco entidade;

	EnumTipoEndereco(TipoEndereco entidade) {
		this.entidade = entidade;
	}

	@Override
	public TipoEndereco getEntidade() {
		return entidade;
	}

	@Override
	public Long getRevisao() {
		return 0L;
	}

	public static List<EnumTipoEndereco> getList() {
		return Arrays.asList(values());
	}

	public static List<TipoEndereco> getListEntidade() {
		List<TipoEndereco> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
