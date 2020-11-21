package br.edu.unoesc.operacaoservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.operacaoservice.common.model.Prioridade;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IRevisao;

public enum EnumPrioridade implements IRevisao, IEnumEntidade<Prioridade> {

	BAIXA(new Prioridade(1L, "Baixa")),
	MEDIA(new Prioridade(2L, "Media")),
	ALTA(new Prioridade(3L, "Alta")),
	CRITICA(new Prioridade(4L, "Crítica")),
	;

	private Prioridade entidade;

	EnumPrioridade(Prioridade entidade) {
		this.entidade = entidade;
	}

	@Override
	public Prioridade getEntidade() {
		return entidade;
	}

	@Override
	public Long getRevisao() {
		return 0L;
	}

	public static List<EnumPrioridade> getList() {
		return Arrays.asList(values());
	}

	public static List<Prioridade> getListEntidade() {
		List<Prioridade> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
