package br.edu.unoesc.operacaoservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.operacaoservice.common.model.StatusIncidente;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IRevisao;

public enum EnumStatusIncidente implements IRevisao, IEnumEntidade<StatusIncidente> {

	ABERTO(new StatusIncidente(1L, "Aberto")),
	EM_ANALISE(new StatusIncidente(2L, "Em análise")),
	AGUARDANDO_PROBLEMA(new StatusIncidente(3L, "Aguardando Problema")),
	RESOLVIDO(new StatusIncidente(4L, "Resolvido")),
	ENCERRADO(new StatusIncidente(5L, "Encerrado")),
    ;

    private StatusIncidente entidade;

    EnumStatusIncidente(StatusIncidente entidade){
        this.entidade = entidade;
    }

    @Override
    public StatusIncidente getEntidade() {
    	return entidade;
    }

    @Override
	public Long getRevisao() {
		return 0L;
	}

	public static List<EnumStatusIncidente> getList() {
		return Arrays.asList(values());
	}

	public static List<StatusIncidente> getListEntidade() {
		List<StatusIncidente> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
