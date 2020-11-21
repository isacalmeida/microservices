package br.edu.unoesc.transicaoservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IRevisao;
import br.edu.unoesc.transicaoservice.common.model.CategoriaItemConfiguracao;

public enum EnumCategoriaItemConfiguracao implements IRevisao, IEnumEntidade<CategoriaItemConfiguracao> {
    
	SOFTWARE(new CategoriaItemConfiguracao(1L, "Software")),
	HARDWARE(new CategoriaItemConfiguracao(2L, "Hardware")),
	LOCALIZACAO(new CategoriaItemConfiguracao(3L, "Localização")),
	NETWORK(new CategoriaItemConfiguracao(4L, "Network")),
    ;

    private CategoriaItemConfiguracao entidade;

    EnumCategoriaItemConfiguracao(CategoriaItemConfiguracao entidade){
        this.entidade = entidade;
    }

    @Override
    public CategoriaItemConfiguracao getEntidade() {
    	return entidade;
    }

    @Override
	public Long getRevisao() {
		return 0L;
	}

	public static List<EnumCategoriaItemConfiguracao> getList() {
		return Arrays.asList(values());
	}

	public static List<CategoriaItemConfiguracao> getListEntidade() {
		List<CategoriaItemConfiguracao> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
