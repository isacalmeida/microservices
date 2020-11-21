package br.edu.unoesc.acessoservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.acessoservice.common.model.TipoServico;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IRevisao;

public enum EnumTipoServico implements IRevisao, IEnumEntidade<TipoServico> {

	ACESSO(new TipoServico(1L, "Acesso")),
    PESSOA(new TipoServico(2L, "Pessoa")),
    OPERACAO(new TipoServico(3L, "Operaçao")),
    TRANSICAO(new TipoServico(4L, "Transição")),
    ;

    private TipoServico entidade;

	private EnumTipoServico(TipoServico entidade) {
		this.entidade = entidade;
	}

	@Override
	public TipoServico getEntidade() {
		return entidade;
	}

	@Override
	public Long getRevisao() {
		return 1L;
	}

	public static List<EnumTipoServico> getList() {
		return Arrays.asList(values());
	}

	public static List<TipoServico> getListEntidade() {
		List<TipoServico> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
