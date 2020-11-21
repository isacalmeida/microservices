package br.edu.unoesc.operacaoservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.operacaoservice.common.model.StatusProblema;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IRevisao;

public enum EnumStatusProblema implements IRevisao, IEnumEntidade<StatusProblema> {

	ABERTO(new StatusProblema(1L, "Aberto")),
	EM_ANALISE(new StatusProblema(2L, "Em análise")),
	AGUARDANDO_MUDANCA(new StatusProblema(3L, "Aguardando Mudança")),
	RESOLVIDO(new StatusProblema(4L, "Resolvido")),
	ENCERRADO(new StatusProblema(5L, "Encerrado")),
    ;

    private StatusProblema entidade;

    EnumStatusProblema(StatusProblema entidade){
        this.entidade = entidade;
    }

    @Override
    public StatusProblema getEntidade() {
    	return entidade;
    }

    @Override
	public Long getRevisao() {
		return 0L;
	}

	public static List<EnumStatusProblema> getList() {
		return Arrays.asList(values());
	}

	public static List<StatusProblema> getListEntidade() {
		List<StatusProblema> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
