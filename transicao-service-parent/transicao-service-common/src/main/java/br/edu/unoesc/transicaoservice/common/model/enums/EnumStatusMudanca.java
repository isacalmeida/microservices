package br.edu.unoesc.transicaoservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IRevisao;
import br.edu.unoesc.transicaoservice.common.model.StatusMudanca;

public enum EnumStatusMudanca implements IRevisao, IEnumEntidade<StatusMudanca> {

	ABERTA(new StatusMudanca(1L, "Aberta")),
	AGUARDANDO_APROVACAO(new StatusMudanca(2L, "Aguardando Aprovação")),
	APROVADA(new StatusMudanca(3L, "Aprovada")),
	REPROVADA(new StatusMudanca(4L, "Reprovada")),
	AGUARDANDO_EXECUCAO(new StatusMudanca(5L, "Aguardando Execução")),
	EM_EXECUCAO(new StatusMudanca(6L, "Em execução")),
	CONCLUIDA_FALHA(new StatusMudanca(7L, "Concluída com Falha")),
	CONCLUIDA_SUCESSO(new StatusMudanca(8L, "Concluída com Sucesso")),
	ENCERRADA(new StatusMudanca(9L, "Encerrada")),
    ;

    private StatusMudanca entidade;

    EnumStatusMudanca(StatusMudanca entidade){
        this.entidade = entidade;
    }

    @Override
    public StatusMudanca getEntidade() {
    	return entidade;
    }

    @Override
	public Long getRevisao() {
		return 0L;
	}

	public static List<EnumStatusMudanca> getList() {
		return Arrays.asList(values());
	}

	public static List<StatusMudanca> getListEntidade() {
		List<StatusMudanca> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
