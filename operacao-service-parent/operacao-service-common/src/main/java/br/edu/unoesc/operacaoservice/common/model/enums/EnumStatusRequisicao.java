package br.edu.unoesc.operacaoservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.operacaoservice.common.model.StatusRequisicao;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IRevisao;

public enum EnumStatusRequisicao implements IRevisao, IEnumEntidade<StatusRequisicao> {
    
	ABERTO(new StatusRequisicao(1L, "Aberto")),
	EM_ANALISE(new StatusRequisicao(2L, "Em análise")),
	AGUARDANDO_INCIDENTE(new StatusRequisicao(3L, "Aguardando Incidente")),
	AGUARDANDO_MUDANCA(new StatusRequisicao(4L, "Aguardando Mudança")),
	ENCERRADO(new StatusRequisicao(5L, "Encerrado")),
    ;

    private StatusRequisicao entidade;

    EnumStatusRequisicao(StatusRequisicao entidade){
        this.entidade = entidade;
    }

    @Override
    public StatusRequisicao getEntidade() {
    	return entidade;
    }

    @Override
	public Long getRevisao() {
		return 0L;
	}

	public static List<EnumStatusRequisicao> getList() {
		return Arrays.asList(values());
	}

	public static List<StatusRequisicao> getListEntidade() {
		List<StatusRequisicao> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
