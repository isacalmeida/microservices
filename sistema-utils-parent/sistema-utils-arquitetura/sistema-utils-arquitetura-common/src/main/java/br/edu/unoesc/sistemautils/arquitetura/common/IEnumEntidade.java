package br.edu.unoesc.sistemautils.arquitetura.common;

public interface IEnumEntidade<E extends IIdentityEntity<Long>> {

	E getEntidade();
}
