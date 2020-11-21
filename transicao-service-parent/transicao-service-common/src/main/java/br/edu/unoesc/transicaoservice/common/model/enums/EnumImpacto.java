package br.edu.unoesc.transicaoservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.model.enums.IRevisao;
import br.edu.unoesc.transicaoservice.common.model.Impacto;

public enum EnumImpacto implements IRevisao, IEnumEntidade<Impacto> {

	BAIXO(new Impacto(1L, "Baixo")),
	MEDIO(new Impacto(2L, "Medio")),
	ALTO(new Impacto(3L, "Alto")),
    ;

    private Impacto entidade;

    EnumImpacto(Impacto entidade){
        this.entidade = entidade;
    }

    @Override
    public Impacto getEntidade() {
    	return entidade;
    }

    @Override
	public Long getRevisao() {
		return 0L;
	}

	public static List<EnumImpacto> getList() {
		return Arrays.asList(values());
	}

	public static List<Impacto> getListEntidade() {
		List<Impacto> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
