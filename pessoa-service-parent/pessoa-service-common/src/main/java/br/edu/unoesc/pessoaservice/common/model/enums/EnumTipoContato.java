package br.edu.unoesc.pessoaservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.pessoaservice.common.model.TipoContato;
import br.edu.unoesc.sistemautils.arquitetura.common.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.IRevisao;

public enum EnumTipoContato implements IRevisao, IEnumEntidade<TipoContato> {

	EMAIL(new TipoContato(1L, "E-mail")), 
	TELEFONE_CELULAR(new TipoContato(2L, "Telefone Celular")),
	TELEFONE_FIXO(new TipoContato(3L, "Telefone Fixo")), 
	WHATSAPP(new TipoContato(4L, "Whatsapp")), 
	;

	private TipoContato entidade;

	EnumTipoContato(TipoContato entidade) {
		this.entidade = entidade;
	}

	@Override
	public TipoContato getEntidade() {
		return entidade;
	}

	@Override
	public Long getRevisao() {
		return 0L;
	}

	public static List<EnumTipoContato> getList() {
		return Arrays.asList(values());
	}

	public static List<TipoContato> getListEntidade() {
		List<TipoContato> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
