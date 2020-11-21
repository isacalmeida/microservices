package br.edu.unoesc.transicaoservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IRevisao;
import br.edu.unoesc.transicaoservice.common.model.StatusItemConfiguracao;

public enum EnumStatusItemConfiguracao implements IRevisao, IEnumEntidade<StatusItemConfiguracao> {
    
	EM_PROJETO(new StatusItemConfiguracao(1L, "Em Projeto")),
	EM_AQUISICAO(new StatusItemConfiguracao(2L, "Em Aquisição")),
	AGUARDANDO_ENTREGA(new StatusItemConfiguracao(3L, "Aguardando Entrega")),
	EM_ESTOQUE(new StatusItemConfiguracao(4L, "Em Estoque")),
	EM_INSTALACAO(new StatusItemConfiguracao(5L, "Em Instalação")),
	EM_PRODUCAO(new StatusItemConfiguracao(6L, "Em Produção")),
	EM_MANUTENCAO(new StatusItemConfiguracao(7L, "Em Manutenção")),
	AGUARDANDO_FORNECEDOR(new StatusItemConfiguracao(8L, "Aguardando Fornecedor")),
	AGUARDANDO_DESCARTE(new StatusItemConfiguracao(9L, "Aguardando Descarte")),
	EXTINTO(new StatusItemConfiguracao(10L, "Extinto")),
    ;

    private StatusItemConfiguracao entidade;

    EnumStatusItemConfiguracao(StatusItemConfiguracao entidade){
        this.entidade = entidade;
    }

    @Override
    public StatusItemConfiguracao getEntidade() {
    	return entidade;
    }

    @Override
	public Long getRevisao() {
		return 1L;
	}

	public static List<EnumStatusItemConfiguracao> getList() {
		return Arrays.asList(values());
	}

	public static List<StatusItemConfiguracao> getListEntidade() {
		List<StatusItemConfiguracao> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
