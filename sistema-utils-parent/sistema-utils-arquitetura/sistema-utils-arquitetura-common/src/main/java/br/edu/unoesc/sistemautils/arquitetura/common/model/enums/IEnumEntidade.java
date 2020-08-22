package br.edu.unoesc.sistemautils.arquitetura.common.model.enums;

import br.edu.unoesc.sistemautils.arquitetura.common.model.IIdentityEntity;

public interface IEnumEntidade<E extends IIdentityEntity<Long>> {

	E getEntidade();
}
