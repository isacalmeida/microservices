package br.edu.unoesc.transicaoservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IRevisao;
import br.edu.unoesc.transicaoservice.common.model.TipoItemConfiguracao;

public enum EnumTipoItemConfiguracao implements IRevisao, IEnumEntidade<TipoItemConfiguracao> {

	SERVIDOR(new TipoItemConfiguracao(1L, "Servidor")),
	ROTEADOR(new TipoItemConfiguracao(2L, "Roteador")),
	COMPUTADOR(new TipoItemConfiguracao(3L, "Computador")),
	RACK(new TipoItemConfiguracao(4L, "Rack")),
	NOBREAK(new TipoItemConfiguracao(5L, "Nobreak")),
	SWITCH(new TipoItemConfiguracao(6L, "Switch")),
	PATCH_PANEL(new TipoItemConfiguracao(7L, "Patch Panel")),
    ;

    private TipoItemConfiguracao entidade;

    EnumTipoItemConfiguracao(TipoItemConfiguracao entidade){
        this.entidade = entidade;
    }

    @Override
    public TipoItemConfiguracao getEntidade() {
    	return entidade;
    }

    @Override
	public Long getRevisao() {
		return 0L;
	}

	public static List<EnumTipoItemConfiguracao> getList() {
		return Arrays.asList(values());
	}

	public static List<TipoItemConfiguracao> getListEntidade() {
		List<TipoItemConfiguracao> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
