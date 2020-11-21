package br.edu.unoesc.operacaoservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.operacaoservice.common.model.StatusEvento;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IRevisao;

public enum EnumStatusEvento implements IRevisao, IEnumEntidade<StatusEvento> {

	ABERTO(new StatusEvento(1L, "Aberto")),
	EM_ANALISE(new StatusEvento(2L, "Em análise")),
	AGUARDANDO_INCIDENTE(new StatusEvento(3L, "Aguardando Incidente")),
	AGUARDANDO_MUDANCA(new StatusEvento(4L, "Aguardando Mudança")),
	ENCERRADO(new StatusEvento(5L, "Encerrado")),
    ;

    private StatusEvento entidade;

    EnumStatusEvento(StatusEvento entidade){
        this.entidade = entidade;
    }

    @Override
    public StatusEvento getEntidade() {
    	return entidade;
    }

    @Override
	public Long getRevisao() {
		return 0L;
	}

	public static List<EnumStatusEvento> getList() {
		return Arrays.asList(values());
	}

	public static List<StatusEvento> getListEntidade() {
		List<StatusEvento> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
