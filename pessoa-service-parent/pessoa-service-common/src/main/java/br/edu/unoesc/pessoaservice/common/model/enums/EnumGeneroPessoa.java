package br.edu.unoesc.pessoaservice.common.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.unoesc.pessoaservice.common.model.GeneroPessoa;
import br.edu.unoesc.sistemautils.arquitetura.common.IEnumEntidade;
import br.edu.unoesc.sistemautils.arquitetura.common.IRevisao;

public enum EnumGeneroPessoa implements IRevisao, IEnumEntidade<GeneroPessoa>  {
    
	HOMEM(new GeneroPessoa(1L, "Homem")),
    MULHER(new GeneroPessoa(2L, "Mulher")),
    AMBOS(new GeneroPessoa(3L, "Ambos")),
    NENHUM(new GeneroPessoa(4L, "Nenhum")),
    ;

    private GeneroPessoa entidade;

	EnumGeneroPessoa(GeneroPessoa entidade){
        this.entidade = entidade;
    }

    @Override
    public GeneroPessoa getEntidade() {
    	return entidade;
    }

    @Override
	public Long getRevisao() {
		return 0L;
	}

	public static List<EnumGeneroPessoa> getList() {
		return Arrays.asList(values());
	}

	public static List<GeneroPessoa> getListEntidade() {
		List<GeneroPessoa> tList = new ArrayList<>();
		getList().forEach(eNum -> tList.add(eNum.getEntidade()));
		return tList;
	}
}
